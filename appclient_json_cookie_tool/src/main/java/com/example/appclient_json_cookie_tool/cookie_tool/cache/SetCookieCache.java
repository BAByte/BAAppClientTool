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

package com.example.ba.myjacksondemo.cookie_tool.cache;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import okhttp3.Cookie;

//是一个对临时缓存的cookies进行操作的类，他是用hashSet存一个List集合，集合里面再存Cookies
public class SetCookieCache implements CookieCache {

    private Set<IdentifiableCookie> cookies;

    //用哈希表来存储，hashSet的特点就是，不能存储重复对象，
    // 所以在使用hashset的时候必须复写equals和hashCode方法
    public SetCookieCache() {
        cookies = new HashSet<>();
    }

    //添加了，先看看IdentifiableCookie是啥？
    @Override
    public void addAll(Collection<Cookie> newCookies) {
        updateCookies(IdentifiableCookie.decorateAll(newCookies));
    }

    /**
     * All cookies will be added to the collection, already existing cookies will be overwritten by the new ones.
     *
     * @param cookies
     */
    private void updateCookies(Collection<IdentifiableCookie> cookies) {
        this.cookies.removeAll(cookies);
        this.cookies.addAll(cookies);
//        for (IdentifiableCookie c:cookies)
//            Log.d("dddccc", "updateCookies: "+c.getCookie());
    }

    @Override
    public void clear() {
        cookies.clear();
    }

    @Override
    public Iterator<Cookie> iterator() {
        return new SetCookieCacheIterator();
    }

    private class SetCookieCacheIterator implements Iterator<Cookie> {

        private Iterator<IdentifiableCookie> iterator;

        public SetCookieCacheIterator() {
            iterator = cookies.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Cookie next() {
            return iterator.next().getCookie();
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    }
}
