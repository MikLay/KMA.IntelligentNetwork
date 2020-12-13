import com.sun.source.tree.NewArrayTree;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;

public class Encoding {
    public static void main(String[] args) {

        System.out.println("Char | US_ASCII | UTF_8 | UTF_16");

        for (int i = 48; i < 91; i++) {
            char c = (char) (i);
            byte c1 = String.valueOf(c).getBytes(StandardCharsets.US_ASCII)[0];
            byte c2 = String.valueOf(c).getBytes(StandardCharsets.UTF_8)[0];
            byte[] c3 = String.valueOf(c).getBytes(StandardCharsets.UTF_16);

            StringBuilder c3R = new StringBuilder();
            for (byte b: c3){
                c3R.append(b);
            }

            System.out.printf("%s    | %s       | %s    | %s%n", c, c1, c2, c3R.toString());
        }

    }
}

      /*  Char | US_ASCII | UTF_8 | UTF_16
        0    | 48       | 48    | -2-1048
        1    | 49       | 49    | -2-1049
        2    | 50       | 50    | -2-1050
        3    | 51       | 51    | -2-1051
        4    | 52       | 52    | -2-1052
        5    | 53       | 53    | -2-1053
        6    | 54       | 54    | -2-1054
        7    | 55       | 55    | -2-1055
        8    | 56       | 56    | -2-1056
        9    | 57       | 57    | -2-1057
        :    | 58       | 58    | -2-1058
        ;    | 59       | 59    | -2-1059
        <    | 60       | 60    | -2-1060
        =    | 61       | 61    | -2-1061
        >    | 62       | 62    | -2-1062
        ?    | 63       | 63    | -2-1063
        @    | 64       | 64    | -2-1064
        A    | 65       | 65    | -2-1065
        B    | 66       | 66    | -2-1066
        C    | 67       | 67    | -2-1067
        D    | 68       | 68    | -2-1068
        E    | 69       | 69    | -2-1069
        F    | 70       | 70    | -2-1070
        G    | 71       | 71    | -2-1071
        H    | 72       | 72    | -2-1072
        I    | 73       | 73    | -2-1073
        J    | 74       | 74    | -2-1074
        K    | 75       | 75    | -2-1075
        L    | 76       | 76    | -2-1076
        M    | 77       | 77    | -2-1077
        N    | 78       | 78    | -2-1078
        O    | 79       | 79    | -2-1079
        P    | 80       | 80    | -2-1080
        Q    | 81       | 81    | -2-1081
        R    | 82       | 82    | -2-1082
        S    | 83       | 83    | -2-1083
        T    | 84       | 84    | -2-1084
        U    | 85       | 85    | -2-1085
        V    | 86       | 86    | -2-1086
        W    | 87       | 87    | -2-1087
        X    | 88       | 88    | -2-1088
        Y    | 89       | 89    | -2-1089
        Z    | 90       | 90    | -2-1090*/