package com.alaka.oceanapp.models;

public class LoginResponse {
    private boolean success;
    private String status;
    private String _uid;

    public LoginResponse(boolean success, String status, String _uid) {
        this.success = success;
        this.status = status;
        this._uid = _uid;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String get_uid() {
        return _uid;
    }

    public void set_uid(String _uid) {
        this._uid = _uid;
    }
}
