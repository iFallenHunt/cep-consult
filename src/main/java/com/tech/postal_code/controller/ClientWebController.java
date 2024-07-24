package com.tech.postal_code.controller;

import com.tech.postal_code.model.Client;
import com.tech.postal_code.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientWebController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/web/clients")
    public String getAllClients(Model model, @RequestParam(required = false) String name) {
        List<Client> clients;
        if (name != null && !name.isEmpty()) {
            clients = clientService.findByName(name);
        } else {
            clients = (List<Client>) clientService.findAll();
        }
        model.addAttribute("clients", clients);
        return "clients";
    }

    @GetMapping("/web/clients/new")
    public String createClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "client_form";
    }

    @GetMapping("/web/clients/details/{id}")
    public String viewClientDetails(@PathVariable Long id, Model model) {
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "client_details";
    }

    @GetMapping("/web/clients/edit/{id}")
    public String editClientForm(@PathVariable Long id, Model model) {
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "client_form";
    }

    @PostMapping("/web/clients/save")
    public String saveClient(@ModelAttribute Client client) {
        if (client.getId() == null) {
            clientService.insert(client);
        } else {
            clientService.update(client.getId(), client);
        }
        return "redirect:/web/clients";
    }
}
