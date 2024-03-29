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
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
	
    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final UsuarioMapper usuarioMapper;
    private final EnderecoService enderecoService;

    public UsuarioEntity salvaUsuario(UsuarioEntity usuarioEntity) {
        return usuarioRepository.save(usuarioEntity);
    }

    public UsuarioResponseDTO gravarUsuarios(UsuarioRequestDTO usuarioRequestDTO) {
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
            UsuarioEntity entity = usuarioRepository.findByEmail(email);
            notNull(entity, "Usuário não encontrado");
            EnderecoEntity enderecoEntity = enderecoService.findByUsuarioId(entity.getId());

            return usuarioMapper.paraUsuarioResponseDTO(entity, enderecoEntity);
        } catch (Exception e) {
            throw new BusinessException("Erro ao buscar dados de usuário", e);
        }
    }

    @Transactional
    public void deletaDadosUsuario(String email) {
        UsuarioEntity entity = usuarioRepository.findByEmail(email);
        usuarioRepository.deleteByEmail(email);
        enderecoService.deleteByUsuarioId(entity.getId());

    }
}
