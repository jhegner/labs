package br.com.jhegnerlabs.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    name = "appFeignClient",
    url = "http://0.0.0.0:3001"
)
public interface AppFeignClient {

    @PostMapping(path = "/labs-response-location")
    ResponseEntity<Void> postDesejo(@RequestBody Desejo desejo);

    @GetMapping (path = "/labs-response-location/{id_desejo}")
    ResponseEntity<Desejo> getDesejo(@PathVariable("id_desejo") String id);

}
