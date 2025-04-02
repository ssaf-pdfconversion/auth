package co.edu.upb.app.domain.models;

import java.io.Serializable;
import java.util.Objects;

public class AppResponse<DataType> implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;
    private String message;
    private DataType data;

    
    public AppResponse(DataType data, String message, boolean success) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    

	public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public DataType getData() {
        return data;
    }

    
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(DataType data) {
        this.data = data;
    }}