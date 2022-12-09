package br.com.senac.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import br.com.senac.model.ArquivoInfo;
import br.com.senac.model.ArquivoModel;
import br.com.senac.repository.ArquivoRepository;


@Controller
public class DownloadArquivoController {

	@Autowired
	ArquivoRepository fileRepository;
	
	/*
	 *  Files' Information
	 */
	@GetMapping("/files")
	public String getListFiles(Model model) {
		List<ArquivoInfo> fileInfos = fileRepository.findAll().stream().map(
				fileModel -> {
					String filename = fileModel.getName();
					String url = MvcUriComponentsBuilder.fromMethodName(DownloadArquivoController.class,
	                        "downloadFile", fileModel.getName().toString()).build().toString();
					return new ArquivoInfo(filename, url); 
				} 
			)
			.collect(Collectors.toList());
	
		model.addAttribute("files", fileInfos);
		return "listaDeArquivos.html";
	}
 
    /*
     * Download Arquivos
     */
	@GetMapping("/files/{filename}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable String filename) {
		ArquivoModel file = fileRepository.findByName(filename);
		return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
					.body(file.getPic());	
	}
}