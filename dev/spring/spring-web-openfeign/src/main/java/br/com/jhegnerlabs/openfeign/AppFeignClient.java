package br.com.jhegnerlabs.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(
    name = "appFeignClient",
    url = "http://0.0.0.0:3001"
)
public interface AppFeignClient {

    @PostMapping(path = "/labs-response-location")
    ResponseEntity<Void> postDesejo(@RequestBody Desejo desejo);

    @GetMapping (path = "/labs-response-location/{id_desejo}")
    ResponseEntity<Desejo> getDesejo(@PathVariable("id_desejo") String id);

    @PostMapping(path = "/labs-post-upload", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    ResponseEntity<Void> postUpload(@RequestBody byte[] fileBytes);

}
