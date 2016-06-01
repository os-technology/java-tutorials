/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.examples.ch02;

/**
 * @author LiuJian
 * 
 */
public interface CharacterSource {

	public void addCharacterListener(CharacterListener cl);

	public void removeCharacterListener(CharacterListener cl);

	public void nextCharacter();

}