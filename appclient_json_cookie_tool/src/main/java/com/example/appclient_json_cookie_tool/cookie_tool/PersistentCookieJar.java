/*
 * Copyright (C) 2016 Francisco José Montiel Navarro.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.ba.myjacksondemo.cookie_tool;


import android.util.Log;

import com.example.ba.myjacksondemo.cookie_tool.cache.CookieCache;
import com.example.ba.myjacksondemo.cookie_tool.cache.SetCookieCache;
import com.example.ba.myjacksondemo.cookie_tool.persistence.CookiePersistor;
import com.example.ba.myjacksondemo.cookie_tool.persistence.SharedPrefsCookiePersistor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.HttpUrl;

public class PersistentCookieJar implements ClearableCookieJar {

    private CookieCache cache;
    private CookiePersistor persistor;

    public PersistentCookieJar(SetCookieCache cache, SharedPrefsCookiePersistor persistor) {
        this.cache = cache;
        this.persistor = persistor;

        this.cache.addAll(persistor.loadAll());
    }

    //在请求后返回数据后会自动调用该方法，在该方法中
    @Override
    synchronized public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        Log.d("ddd", "saveFromResponse: 返回数据");
        for (Cookie c : cookies)
            Log.d("ddd", "saveFromResponse: 返回然后保存的cookie" + c);
        // Log.d("ddd", "saveFromResponse: "+cookies.get(1));
        cache.addAll(cookies);
        persistor.saveAll(cookies);
    }

    @Override
    synchronized public List<Cookie> loadForRequest(HttpUrl url) {

        Log.d("ddd", "loadForRequest: 发起请求");
        List<Cookie> removedCookies = new ArrayList<>();
        List<Cookie> validCookies = new ArrayList<>();

        for (Iterator<Cookie> it = cache.iterator(); it.hasNext(); ) {
            Cookie currentCookie = it.next();

            if (isCookieExpired(currentCookie)) {
                removedCookies.add(currentCookie);
                it.remove();

            } else if (currentCookie.matches(url)) {
                validCookies.add(currentCookie);
            }
        }

        persistor.removeAll(removedCookies);

        for (Cookie c : validCookies)
            Log.d("ddd", "loadForRequest: 放在请求头的cookie" + c);
        for (Cookie c : removedCookies)
            Log.d("ddd", "loadForRequest: 需要实时更新的cookie" + c);
        return validCookies;
    }

    private static boolean isCookieExpired(Cookie cookie) {
        return cookie.expiresAt() < System.currentTimeMillis();
    }

    synchronized public void clear() {
        cache.clear();
        persistor.clear();
    }
}
