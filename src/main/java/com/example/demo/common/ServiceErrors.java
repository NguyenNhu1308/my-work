package com.example.demo.common;

public class ServiceErrors {
    public static final ServiceError SUCCESS = new ServiceError(0, "Thành công");
    public static final ServiceError ERROR = new ServiceError(99, "Có lỗi xảy ra");
    public static final ServiceError BAD_REQUEST = new ServiceError(1, "Yêu cầu không hợp lệ");
    public static final ServiceError FORBIDDEN = new ServiceError(403, "Bạn chưa có quyền truy cập vào hệ thống Văn phòng 123");
    public static final ServiceError USERNAME_OR_PASSWORD_INCORRECT = new ServiceError(3, "Tài khoản hoặc mật khẩu không chính xác");
    public static final ServiceError ERRORS = new ServiceError(999, "Có lỗi xảy ra");
}
