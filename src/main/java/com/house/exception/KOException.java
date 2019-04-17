package com.house.exception;

public class KOException extends RuntimeException {

    private static final long serialVersionUID = -6293662498600553602L;
    private IError error;
    private String extMessage;

    public KOException(){
        this.error=KOError.SYSTEM_INTERNAL_ERROR;
        this.extMessage=null;
    }

    public KOException(String message){
        super(message);
        this.error = KOError.SYSTEM_INTERNAL_ERROR;
        this.extMessage=null;
        this.extMessage=message;
    }

    public KOException(String message, Throwable cause){
        super(message, cause);
        this.error = KOError.SYSTEM_INTERNAL_ERROR;
        this.extMessage=null;
        this.extMessage = message;
    }

    public KOException(Throwable cause){
        super(cause);
        this.error=KOError.SYSTEM_INTERNAL_ERROR;
        this.extMessage = null;
        if (cause instanceof  KOException){
            KOException fe = (KOException)cause;
            this.error = fe.getError();
            this.extMessage = fe.getMessage();
        }
    }

    public KOException(IError error){
        super(error.getErrorCode()+":"+error.getErrorMessage());
        this.error = KOError.SYSTEM_INTERNAL_ERROR;
        this.extMessage = null;
        this.error = error;
    }

    public KOException(IError error, String message){
        super(error.getErrorCode()+":"+error.getErrorMessage());
        this.error = KOError.SYSTEM_INTERNAL_ERROR;
        this.extMessage = null;
        this.error = error;
        this.extMessage = message;
    }

    public KOException(Throwable cause, IError error, String message){
        super(message, cause);
        this.error = KOError.SYSTEM_INTERNAL_ERROR;
        this.extMessage = null;
        this.extMessage = message;
        this.error = error;
    }

    public KOException(IError error, Throwable cause){
        super(cause);
        this.error = KOError.SYSTEM_INTERNAL_ERROR;
        this.extMessage = null;
        this.error = error;
    }


    public IError getError() {
        return this.error;
    }

    public String getExtMessage() {
        return this.extMessage;
    }

    public void setExtMessage(String extMessage) {
        this.extMessage = extMessage;
    }

    public String toString() {
        return super.toString() + ",ErrorCode : " + this.error.getErrorCode() + ", ErrorMessage : " + this.error.getErrorMessage() + ", ExtMessage : " + this.extMessage;
    }

}
