package labs;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

public class Base64Labs {

    public static void main(String[] args) throws IOException, URISyntaxException {


        var pathFile = "geran-de-klerk-wYy3rvvgjAU-unsplash.jpg";

        Path path = Paths.get(Objects.requireNonNull(Base64Labs.class.getResource("/geran-de-klerk-wYy3rvvgjAU-unsplash.jpg")).toURI());

        var bytesFile = Files.readAllBytes(path);

//        var base64 = Base64.getEncoder().encode(bytesFile);
//        var base64Byte = Base64.getEncoder().encode(bytesFile);

        // codifica
        var base64String = Base64.getEncoder().encodeToString(bytesFile);

//        Path path2 = Path.of("geran-de-klerk-wYy3rvvgjAU-unsplash_base64.txt");
//        Files.write(path2, base64Byte);
//
        var base64Decodificado = Base64.getDecoder().decode(base64String);
        Path path2 = Path.of("geran-de-klerk-wYy3rvvgjAU-unsplash_decoded.jpg");
        Files.write(path2, base64Decodificado);

//        System.out.println(base64);
    }
}
