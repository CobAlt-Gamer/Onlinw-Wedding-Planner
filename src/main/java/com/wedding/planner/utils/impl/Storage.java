
package com.wedding.planner.utils.impl;

import com.wedding.planner.utils.StorageUtil;

public class Storage implements StorageUtil {
	public static final String STORAGE_ROOT = "";
	public static final String STORAGE_STATIC = "static";
	public static final String STORAGE_CATEGORIES = STORAGE_STATIC + "/categories";
	public static final String STORAGE_SERVICE_ITEMS = STORAGE_STATIC + "/service_items";
	public static final String STORAGE_AVATAR = "avatar";
	public static final String STORAGE_DEFAULT = "default";
	public static final String STORAGE_USERS = "users";
	public static final String STORAGE_INSPIRATIONS = STORAGE_USERS + "/inspirations";
}