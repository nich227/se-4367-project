/**
 * Copyright 2010 Mozilla Foundation
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mozilla.util;

public class StringUtil {

	public static boolean isBlank(String s) {
		return (s == null || s.length() == 0 || s.trim().length() == 0);
	}
	
	public static String join(String glue, String... bits) {
	    if (bits == null)
	        return null;
	    if (bits.length == 0)
	        return "";

	    StringBuilder sb = new StringBuilder(bits[0]);
	    for (int i = 1; i < bits.length; i++) {
	        sb.append(glue);
	        sb.append(bits[i]);
	    }
	    return sb.toString();
	}

}
