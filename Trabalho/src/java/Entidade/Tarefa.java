/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author savio
 */
@Entity
public class Tarefa implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 70)
    private String titulo;
    
    @Column(nullable = false, length = 150)
    private String descricao;
    
    @Column(columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataParaConclusao;
    
    @Column(columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataConclusao;
    
    private Etiqueta etiqueta;
    
    public Tarefa(){}

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the dataParaConclusao
     */
    public Date getDataParaConclusao() {
        return dataParaConclusao;
    }

    /**
     * @param dataParaConclusao the dataParaConclusao to set
     */
    public void setDataParaConclusao(Date dataParaConclusao) {
        this.dataParaConclusao = dataParaConclusao;
    }

    /**
     * @return the dataConclusao
     */
    public Date getDataConclusao() {
        return dataConclusao;
    }

    /**
     * @param dataConclusao the dataConclusao to set
     */
    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    /**
     * @return the etiqueta
     */
    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    /**
     * @param etiqueta the etiqueta to set
     */
    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    
}
