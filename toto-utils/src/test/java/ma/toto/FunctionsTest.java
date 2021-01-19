package ma.toto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FunctionsTest {

  @Test
  void given_null_should_return_null() {
    assertThat(Functions.nullPassThroug(null, () -> new Object())).isNull();
  }

  @Test
  void given_not_null_should_return_not_null() {
    assertThat(Functions.nullPassThroug(new Object(), () -> new Object())).isNotNull();
  }

  @Test
  void given_not_null_should_return_supplier_object() {
    var object = new Object();
    assertThat(Functions.nullPassThroug(new Object(), () -> object)).isEqualTo(object);
  }
}
