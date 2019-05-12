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
package xxx.necklaceservice.creator;

import xxx.necklaceservice.exception.CustomException;
import xxx.necklaceservice.model.IProduct;

/**
 * The {@code IFactory} interface provide method for creation {@code IProduct} instances
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
	 *
	 * @param elementsString {@code String} representation of {@code IProduct}
	 * @return instance of {@code IProduct}
	 * @throws CustomException if {@param elementsString} is incorrect
	 */
	IProduct create(String[] elementsString) throws CustomException;
}