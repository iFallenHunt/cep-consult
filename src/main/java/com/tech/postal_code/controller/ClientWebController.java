package com.tech.postal_code.controller;

import com.tech.postal_code.model.Client;
import com.tech.postal_code.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/clients")
@RequiredArgsConstructor
public class ClientWebController {

    private final ClientService clientService;

    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "clients";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("client", new Client());
        return "client_form";
    }

    @PostMapping
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.insert(client);
        return "redirect:/web/clients";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "client_form";
    }

    @PostMapping("/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute("client") Client client) {
        clientService.update(id, client);
        return "redirect:/web/clients";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.delete(id);
        return "redirect:/web/clients";
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable Long id, Model model) {
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "client_details";
    }
}
