package com.tfs.dxconfig;
/**
 * 信息重定向方法
 */
@FunctionalInterface
public interface MessageRedirector {
    /**
     * 重定向方法
     * @param message 信息内容
     * @param head 信息类型头
     */
    public void log(String message, String head);
}
