package br.com.thyagojose.sistemadegerenciamentodefuncionarios.services;

import br.com.thyagojose.sistemadegerenciamentodefuncionarios.entities.Funcionario;
import br.com.thyagojose.sistemadegerenciamentodefuncionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FuncionarioService {

    @Autowired
   private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public boolean existsNome(String nome) {
        return funcionarioRepository.existsBynome(nome);
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> findById(UUID id) {
        return funcionarioRepository.findById(id);
    }

    @Transactional      //Transactional se algo der errado ele cai em Ralback.
    public void delete(Funcionario funcionario) {
       funcionarioRepository.delete(funcionario);
    }
}

//    final FuncionarioRepository funcionarioRepository;
//
//    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
//        this.funcionarioRepository = funcionarioRepository;
//    }

//    @Autowired
//    private FuncionarioRepository funcionarioRepository;
//
//    @Autowired
//    private final FuncionarioMapper funcionarioMapper = FuncionarioMapper.INSTANCE;
//
//
//
////    public MessageResponseDTO createFuncionario(FuncionarioDTO funcionarioDTO) {
////        Funcionario funcionarioToSave = funcionarioMapper.toModel(funcionarioDTO);
////
////        Funcionario savedFuncionario = funcionarioRepository.save(funcionarioToSave);
////        return createMessageResponse(savedFuncionario.getId(), "Created person with ID ");
////    }
//
//
////    @Transactional(readOnly = true)
////    public Page<FuncionarioDTO> findAll(Pageable pageable) {
////            Page<Funcionario> result = funcionarioRepository.findAll(pageable);
////            Page<FuncionarioDTO> page = result.map(x -> new FuncionarioDTO(x));
////            return page;
////    }
//
//    public List<FuncionarioDTO> listAll() {
//        List<Funcionario> allPeople = funcionarioRepository.findAll();
//        return allPeople.stream()
//            .map(funcionarioMapper::toDTO)
//               .collect(Collectors.toList());
//    }
//
//
////    @Transactional(readOnly = true)
////    public FuncionarioDTO findById(Long id) throws FuncionarioNotFoundException{
////        Funcionario result = funcionarioRepository.findById(id).get();
////        FuncionarioDTO dto = new FuncionarioDTO(result);
////        return dto;
////    }
//
//    public FuncionarioDTO findById(Long id) throws FuncionarioNotFoundException {
//       Funcionario funcionario = verifyIfExists(id);
//
//        return funcionarioMapper.toDTO(funcionario);
//    }
//
//    public void delete(Long id) throws FuncionarioNotFoundException {
//        verifyIfExists(id);
//        funcionarioRepository.deleteById(id);
//    }
//
//
////    public MessageResponseDTO updateById(Long id, FuncionarioDTO funcionarioDTO) throws FuncionarioNotFoundException{
////        verifyIfExists(id);
////        Funcionario funcionarioToUpdate = funcionarioMapper.toModel(funcionarioDTO);
////        Funcionario updatedFuncionario = funcionarioRepository.save(funcionarioToUpdate);
////        return createMessageResponse(updatedFuncionario.getId(), "Updated person with ID ");
////    }
//
//    private Funcionario verifyIfExists(Long id) throws FuncionarioNotFoundException {
//        return funcionarioRepository.findById(id)
//                .orElseThrow(() -> new FuncionarioNotFoundException(id));
//    }
//
////    private MessageResponseDTO createMessageResponse(Long id, String message) {
////        return MessageResponseDTO
////                .builder()
////                .message(message + id)
////                .build();
////    }


//}
