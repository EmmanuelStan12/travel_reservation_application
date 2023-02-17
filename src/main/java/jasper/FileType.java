package jasper;

import utils.Operator;

import java.util.Objects;

public enum FileType {
    PDF("pdf"), EXCEL("excel");

    private String fileType;

    FileType(String fileType) {
        this.fileType = fileType;
    }

    public static FileType findType(String type) {
        if (Objects.equals(PDF.getFileType(), type)) {
            return PDF;
        }
        if (Objects.equals(EXCEL.getFileType(), type)) {
            return EXCEL;
        }
        return null;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
