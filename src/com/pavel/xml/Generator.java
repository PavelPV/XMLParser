package com.pavel.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Generator {
	
	private List<Blocks_item> blocks_item;
	
	public Generator() {}

	public List<Blocks_item> getBlocks_item() {
		return blocks_item;
	}
	@XmlElementWrapper(name="blocks")
	public void setBlocks_item(List<Blocks_item> blocks_item) {
		this.blocks_item = blocks_item;
	}

	@Override
	public String toString() {
		return "Generator [blocks_item=" + blocks_item + "]";
	}
	
}
