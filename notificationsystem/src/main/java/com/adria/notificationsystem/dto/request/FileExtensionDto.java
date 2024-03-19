package com.adria.notificationsystem.dto.request;

public enum FileExtensionDto {
    pdf, jpg, jpeg, png;

    public static boolean isValid(String fileExtension) {
        try {
            FileExtensionDto.valueOf(fileExtension.toLowerCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
