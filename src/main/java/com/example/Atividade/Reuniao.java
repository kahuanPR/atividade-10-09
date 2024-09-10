package com.example.Atividade;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Reuniao {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String titulo;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String pauta;
    private String descricao;
    private String setor;
    private boolean publica;
    
    
    @ElementCollection
    @CollectionTable(name = "palavras_chave")
    private Set<String> palavrasChave;

    @ManyToOne
    private Funcionario emissor;

    @ManyToMany
    private Set<Participante> participantes;

    @Enumerated(EnumType.STRING)
    private EstadoAta estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public LocalDateTime getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(LocalDateTime dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public String getPauta() {
		return pauta;
	}

	public void setPauta(String pauta) {
		this.pauta = pauta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public boolean isPublica() {
		return publica;
	}

	public void setPublica(boolean publica) {
		this.publica = publica;
	}

	public Set<String> getPalavrasChave() {
		return palavrasChave;
	}

	public void setPalavrasChave(Set<String> palavrasChave) {
		this.palavrasChave = palavrasChave;
	}

	public Funcionario getEmissor() {
		return emissor;
	}

	public void setEmissor(Funcionario emissor) {
		this.emissor = emissor;
	}

	public Set<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<Participante> participantes) {
		this.participantes = participantes;
	}

	public EstadoAta getEstado() {
		return estado;
	}

	public void setEstado(EstadoAta estado) {
		this.estado = estado;
	}
	
	enum EstadoAta {
	    EMITIDA,
	    EM_PROCESSO_DE_REVISAO,
	    EM_PROCESSO_DE_CONCLUSAO
	}
}
