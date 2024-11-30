package com.yeowon.demo.exception.Product;

import com.yeowon.demo.exception.ErrorCode;
import com.yeowon.demo.exception.StudyException;

public class ProductNameDuplicateException extends StudyException {
    public ProductNameDuplicateException() {
        super(ErrorCode.MEMBER_NAME_DUPLICATE_ERROR);
    }
}
