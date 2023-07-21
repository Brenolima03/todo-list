package com.todolist.todolist.model.enums;

public enum TaskStatus {
    NOT_ASSIGNED(1),
    INCOMPLETE(2),
    COMPLETE(3);

    private Integer code;

    private TaskStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static TaskStatus valueOf(Integer code) {
        for (TaskStatus value : TaskStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TaskStatus code");
    }
}
