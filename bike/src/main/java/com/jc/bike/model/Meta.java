package com.jc.bike.model;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.model
 * @className: Meta
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/19 11:40
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/19 11:40     lijp6      v1.1.0              修改原因
 **/
public class Meta {
    private Byte keepAlive;

    private Byte requireAuth;

    public Byte getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Byte keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Byte getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Byte requireAuth) {
        this.requireAuth = requireAuth;
    }
}