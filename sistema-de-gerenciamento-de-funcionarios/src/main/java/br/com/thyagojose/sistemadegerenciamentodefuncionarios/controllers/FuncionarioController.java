package br.com.thyagojose.sistemadegerenciamentodefuncionarios.controllers;

import br.com.thyagojose.sistemadegerenciamentodefuncionarios.dto.FuncionarioDTO;
import br.com.thyagojose.sistemadegerenciamentodefuncionarios.entities.Funcionario;
import br.com.thyagojose.sistemadegerenciamentodefuncionarios.repository.FuncionarioRepository;
import br.com.thyagojose.sistemadegerenciamentodefuncionarios.services.FuncionarioService;
//import lombok.AllArgsConstructor;
//import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.OAEPParameterSpec;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
//@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    final FuncionarioService funcionarioService;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioService funcionarioService, FuncionarioRepository funcionarioRepository) {
        this.funcionarioService = funcionarioService;
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping
    public ResponseEntity<Object> saveFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO){
        if(funcionarioService.existsNome(funcionarioDTO.getNome())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome existente");
        }
        Funcionario funcionario = new Funcionario();
        BeanUtils.copyProperties(funcionarioDTO, funcionario); //Converte de DTO para model
        //funcionario.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.save(funcionario));
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> getAllFuncionario(){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneFuncionario(@PathVariable(value = "id") UUID id){
        Optional<Funcionario> funcionarioOptional= funcionarioService.findById(id);
        if(!funcionarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFuncionario(@PathVariable(value = "id") UUID id){
        Optional<Funcionario> funcionarioOptional = funcionarioService.findById(id);
        if(!funcionarioOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado.");
        }
        funcionarioService.delete(funcionarioOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Funcionario deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFuncionario(@PathVariable(value = "id") UUID id, @RequestBody @Valid FuncionarioDTO funcionarioDTO){
        Optional<Funcionario> funcionarioOptional = funcionarioService.findById(id);
        if(!funcionarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado");
        }
        Funcionario funcionario = funcionarioOptional.get();
        funcionario.setCep(funcionarioDTO.getCep());
        funcionario.setIdade(funcionarioDTO.getIdade());
        funcionario.setSexo(funcionarioDTO.getSexo());
        funcionario.setNome(funcionarioDTO.getNome());

        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.save(funcionario));
    }

    //Esta é outra forma de fazer o put

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateFuncionario(@PathVariable(value = "id") UUID id, @RequestBody @Valid FuncionarioDTO funcionarioDTO) {
//        Optional<Funcionario> funcionarioOptional = funcionarioService.findById(id);
//        if (!funcionarioOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado");
//        }
//        Funcionario funcionario = new Funcionario();
//        BeanUtils.copyProperties(funcionarioDTO, funcionario);
//        funcionario.setId(funcionarioOptional.get().getId());
//        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.save(funcionario));
//    }



}

