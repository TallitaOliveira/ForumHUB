package br.com.alura.challenge.forumhub.controller;


import br.com.alura.challenge.forumhub.domain.usuario.DadosAutenticacao;
import br.com.alura.challenge.forumhub.domain.usuario.Usuario;
import br.com.alura.challenge.forumhub.infra.security.JwtTokenData;
import br.com.alura.challenge.forumhub.infra.security.JwtTokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        var TokenJWT = jwtTokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new JwtTokenData(TokenJWT));
    }
}
