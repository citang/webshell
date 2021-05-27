package utils;

/***
 * @FileName    : UploadUtils.java
 * @Author      : citang
 * @Date        : 2021/5/24 2:29 下午
 * @Description : description the function of the file
 */

public class UploadUtils {
    public static String getRealName(String path) {
        int index = path.lastIndexOf("\\");
        if (index == -1) {
            index = path.lastIndexOf("/");
        }
        return path.substring(index + 1);
    }
}
