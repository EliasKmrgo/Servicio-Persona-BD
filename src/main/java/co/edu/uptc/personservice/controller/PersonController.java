package co.edu.uptc.personservice.controller;

import co.edu.uptc.personservice.dto.*;
import co.edu.uptc.personservice.service.PersonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.net.*;
import java.util.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService service;

    @Value("${id}")
    private String idPrograma;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Object> getAll() throws Exception {

        return Map.of(
                "datos", service.getAll(),
                "origen", idPrograma,
                "ip", obtenerIP()
        );
    }

    @PostMapping
    public Map<String, Object> save(@RequestBody PersonRequest request) throws Exception {

        return Map.of(
                "persona", service.save(request),
                "origen", idPrograma,
                "ip", obtenerIP()
        );
    }

    private String obtenerIP() throws SocketException {

        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();

            Enumeration<InetAddress> direcciones = ni.getInetAddresses();

            while (direcciones.hasMoreElements()) {
                InetAddress direccion = direcciones.nextElement();

                if (!direccion.isLoopbackAddress() && direccion instanceof Inet4Address) {
                    return direccion.getHostAddress();
                }
            }
        }
        return "No encontrada";
    }
}