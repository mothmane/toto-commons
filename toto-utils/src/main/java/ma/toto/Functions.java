package ma.toto;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Utils class containing some generic utils functions
 *
 * @author Othmane Maniar
 * @since 1.0
 */
public final class Functions {

  /* private Constructor to prevent the class from beein instantiated*/
  private Functions() {}

  /**
   * if the object is null the supplier is never called and the method returns null
   *
   * @param source
   * @param supplier
   * @param <T>
   * @return
   */
  public static <T> T nullPassThroug(Object source, Supplier<T> supplier) {
    return Objects.nonNull(source) ? supplier.get() : null;
  }
}
