package com.act.bradesco.users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.act.bradesco.users.DTO.UsuarioRequestDTO;
import com.act.bradesco.users.converter.UsuarioConverter;
import com.act.bradesco.users.entity.EnderecoEntity;
import com.act.bradesco.users.entity.UsuarioEntity;
import com.act.bradesco.users.excpetions.BusinessException;
import com.act.bradesco.users.mapper.UsuarioMapper;
import com.act.bradesco.users.repository.UsuarioRepository;
import com.act.bradesco.users.response.UsuarioResponseDTO;
import static org.springframework.util.Assert.notNull;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
	
	@Autowired
    private final UsuarioRepository usuarioRepository;
    
	@Autowired
	private final UsuarioConverter usuarioConverter;
    
	@Autowired
	private final UsuarioMapper usuarioMapper;
    
    @Autowired
    private final EnderecoService enderecoService;

    public UsuarioEntity salvaUsuario(UsuarioEntity usuarioEntity) {
        return usuarioRepository.save(usuarioEntity);
    }

    public UsuarioResponseDTO gravarUsuarios(UsuarioRequestDTO usuarioRequestDTO) {
    	System.out.println("Passou Service");
    	try {
            notNull(usuarioRequestDTO, "Os dados do usuário são obrigatórios");
            UsuarioEntity usuarioEntity = salvaUsuario(usuarioConverter.paraUsuarioEntity(usuarioRequestDTO));
            EnderecoEntity enderecoEntity = enderecoService.salvaEndereco(
                    usuarioConverter.paraEnderecoEntity(usuarioRequestDTO.getEndereco(), usuarioEntity.getId()));
            return usuarioMapper.paraUsuarioResponseDTO(usuarioEntity, enderecoEntity);
        } catch (Exception e) {
            throw new BusinessException("Erro ao gravar dados de usuário", e);
        }
    }


    public UsuarioResponseDTO buscaDadosUsuario(String email) {
        try {
            UsuarioEntity usuarioEntity = usuarioRepository.findByEmail(email);
            notNull(usuarioEntity, "Usuário não encontrado");
            EnderecoEntity enderecoEntity = enderecoService.findByUsuarioId(usuarioEntity.getId());

            return usuarioMapper.paraUsuarioResponseDTO(usuarioEntity, enderecoEntity);
        } catch (Exception e) {
            throw new BusinessException("Erro ao buscar dados de usuário", e);
        }
    }

    @Transactional
    public void deletaDadosUsuario(String email) {
        UsuarioEntity usuarioEntity = usuarioRepository.findByEmail(email);
        usuarioRepository.deleteByEmail(email);
        enderecoService.deleteByUsuarioId(usuarioEntity.getId());

    }
}
