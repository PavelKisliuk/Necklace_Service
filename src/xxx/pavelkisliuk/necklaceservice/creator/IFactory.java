/*
 * By Pavel Kisliuk, 10.05.2019
 * This is class for education and nothing rights don't reserved.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package xxx.pavelkisliuk.necklaceservice.creator;

import xxx.pavelkisliuk.necklaceservice.model.IProduct;

/**
 * The {@code IFactory} interface provide method for creation {@code IProduct} instances
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see StoneCreator
 * @see GemstoneCreator
 * @see CanvasCreator
 * @see NecklaceElementCreator
 * @see NecklaceCreator
 * @see IProduct
 * @since 12.0
 */
public interface IFactory {
	/**
	 * Create {@code IProduct} instance and return it
	 * <p>
	 *
	 * @param elementsString {@code String} representation of {@code IProduct}
	 * @return instance of {@code IProduct}
	 */
	IProduct create(String[] elementsString);
}