package com.salomia.zk.endpoint.rest.controller.health;


import com.salomia.zk.service.StoredIntService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoredInController {
    private final StoredIntService storedIntService;

    public StoredInController(StoredIntService storedIntService) {
        this.storedIntService = storedIntService;
    }

    @GetMapping("/stored-int")
    public String storedInInt() {
        return storedIntService.storedInInt();
    }
}
