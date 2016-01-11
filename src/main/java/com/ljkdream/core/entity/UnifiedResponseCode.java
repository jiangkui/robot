package com.ljkdream.core.entity;
public interface UnifiedResponseCode {

	/** 200 成功（RC表示ResponseCode，加这个前缀是以免跟ActionSupport定义的响应码冲突）*/
	public static final int RC_SUCC = 200;
	public static final int RC_FAIL = 400;
	public static final int RC_FAIL_401 = 401;
	public static final int RC_FAIL_402 = 402;
	public static final int RC_FAIL_403 = 403;
	public static final int RC_FAIL_404 = 404;
	public static final int RC_FAIL_405 = 405;
	public static final int RC_FAIL_406 = 406;
	public static final int RC_FAIL_407 = 407;
	public static final int RC_FAIL_408 = 408;
	public static final int RC_FAIL_409 = 409;
	public static final int RC_FAIL_410 = 410;
	public static final int RC_ERROR = 500;
}