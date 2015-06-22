package com.controller;

import org.bson.types.ObjectId;

public class JetSki {
	private ObjectId _id;
	private String descricao;
	private Integer hp;
	private Integer peso;
	public JetSki(){}
	public JetSki(ObjectId _id, String descricao, Integer hp, Integer peso) {
		super();
		this._id = _id;
		this.descricao = descricao;
		this.hp = hp;
		this.peso = peso;
	}
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getHp() {
		return hp;
	}
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "JetSki [_id=" + _id + ", descricao=" + descricao + ", hp=" + hp
				+ ", peso=" + peso + "]";
	}
	
	
}
