package ly.turing.util;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

@Data
public final class ErrorObject {
    private static LinkedHashSet<String> parameterSet = new LinkedHashSet<>();

    static {
        parameterSet.add("code");
        parameterSet.add("message");
        parameterSet.add("field");
        parameterSet.add("status");
    }

    private final String code;
    private final String message;
    private final String field;
    private final int status;

    private ErrorObject(String code, String message, String field, int status) {
        this.code = code;
        this.message = message;
        this.field = field;
        this.status = status;
    }

    public static boolean isErrorObject(Object object) {
        if (object instanceof ErrorObject) {
            return true;
        }
        if (object instanceof LinkedHashMap) {
            if (((LinkedHashMap) object).size() != 4) {
                return false;
            }
            return parameterSet.equals(((LinkedHashMap) object).keySet());


        }

        return false;
    }

    public static class Builder {
        private String code;
        private String message;
        private String field;
        private int status;

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setField(String field) {
            this.field = field;
            return this;
        }

        public Builder setStatus(int status) {
            this.status = status;
            return this;
        }

        public ErrorObject get() {
            if (code == null) {
                throw new IllegalStateException("Error code, input required");
            } else if (message == null) {
                throw new IllegalStateException("Error message, input required");
            } else if (field == null) {
                throw new IllegalStateException("Error field, input required");
            } else if (status == 0) {
                throw new IllegalStateException("Error status, input required");
            }
            return new ErrorObject(code, message, field, status);
        }


    }

//    @Override
//    public String toString() {
//        StringBuilder jsonBuilder = new StringBuilder();
//        return jsonBuilder.append("{")
//                .append("\"error\": ").append("{\n")
//                .append("\t\"status\": ").append("\"").append(status).append("\"").append(",\n")
//                .append("\t\"code\": ").append("\"").append(code).append("\"").append(",\n")
//                .append("\t\"message\": ").append("\"").append(message).append("\"").append(",\n")
//                .append("\t\"field\": ").append("\"").append(field).append("\"").append("\n")
//                .append("\t}\n")
//                .append("}").toString();
//    }
}
