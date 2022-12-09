package br.com.senac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="file_model")
public class ArquivoModel {
	
	@Id
	@GeneratedValue
    @Column(name = "id")
    private Long id;
	
    @Column(name = "name")
	private String name;
    
    @Column(name = "mimetype")
	private String mimetype;
	
	@Lob
    @Column(name="pic")
    private byte[] pic;
	
	public ArquivoModel(){}
	
	public ArquivoModel(String name, String mimetype, byte[] pic){
		this.name = name;
		this.mimetype = mimetype;
		this.pic = pic;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getMimetype(){
		return this.mimetype;
	}
	
	public void setMimetype(String mimetype){
		this.mimetype = mimetype;
	}
	
	public byte[] getPic(){
		return this.pic;
	}
	
	public void setPic(byte[] pic){
		this.pic = pic;
	}

}