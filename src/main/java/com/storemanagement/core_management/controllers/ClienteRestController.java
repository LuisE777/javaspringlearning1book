package com.storemanagement.core_management.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domains.Cliente;
@RestController
@RequestMapping("/clientes")
public class ClienteRestController {
	private List<Cliente>clientes =  new ArrayList<>(
			Arrays.asList(
						new Cliente("arm","1234","Armstrong"),
						new Cliente("ald","1234","Aldrin"),
						new Cliente("col","1234","Collins")
					)
	);
	@GetMapping
	public List<Cliente> getClientes(){
		return clientes;
	}
	
	@GetMapping("/{userName}")
	public Cliente getCliente(@PathVariable String userName){
		for(Cliente cli:clientes) {
			if(cli.getUsername().equalsIgnoreCase(userName)) {
				return cli;
			}
		}
		return null;
	}
	
	@GetMapping("/clientes2/{userName}")
	public Cliente getCliente2(@PathVariable String userName){
		return clientes.stream().
				filter(cliente -> cliente.getUsername().equalsIgnoreCase(userName))
				.findFirst()
				.orElseThrow();
	}
	
	@PostMapping
	public Cliente altaCliente(@RequestBody Cliente cliente) {
		clientes.add(cliente);
		return cliente;
	}
	
	@PutMapping
	public Cliente modificacionCliente(@RequestBody Cliente cliente) {
		Cliente clienteEncontrado = clientes.stream()
				.filter(cli -> cli.getUsername().equalsIgnoreCase(cliente.getUsername())).findFirst().orElseThrow();
		clienteEncontrado.setPassword(cliente.getPassword());
		clienteEncontrado.setNombre(cliente.getNombre());
		return clienteEncontrado;
	}
	
	@DeleteMapping("/{userName}")
	public void deleteCliente(@PathVariable String userName) {
		Cliente clienteEncontrado = clientes.stream().
				filter(cli -> cli.getUsername().equalsIgnoreCase(userName)).
				findFirst().orElseThrow();
		clientes.remove(clienteEncontrado);
	}
	
	
	
	
	
}
