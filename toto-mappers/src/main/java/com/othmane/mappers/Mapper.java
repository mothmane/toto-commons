package com.othmane.mappers;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static ma.toto.Functions.nullPassThroug;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Mapper interface used to define defaults for stream, list and set mapping.
 *
 * @param <M> the model type parameter
 * @param <E> the other (entity, dto) type parameter
 * @author Othmane Maniar
 * @since 1.0
 */
public interface Mapper<M, E> {

  /**
   * Maps an object to our domain model.
   *
   * @param source source the entity or dto object
   * @return the domain model destination
   */
  M toModel(E source);

  /**
   * Maps a domain model to on entity or dto object.
   *
   * @param source the domain model object
   * @return the destination object
   */
  E fromModel(M source);

  /**
   * Maps a source list to our domain model list.
   *
   * @param source the objects List
   * @return the destination domain model List
   */
  default List<M> toModel(List<E> source) {
    return nullPassThroug(source, () -> source.stream().map(this::toModel).collect(toList()));
  }

  /**
   * Maps domain model list to a destination object list.
   *
   * @param source the domain model List
   * @return the destination List
   */
  default List<E> fromModel(List<M> source) {
    return nullPassThroug(source, () -> source.stream().map(this::fromModel).collect(toList()));
  }

  /**
   * Maps a source set to a domain model set.
   *
   * @param source the objects Set
   * @return the destination domain model Set
   */
  default Set<M> toModel(Set<E> source) {
    return nullPassThroug(source, () -> source.stream().map(this::toModel).collect(toSet()));
  }

  /**
   * Maps a source domain model set to a destination set.
   *
   * @param source the domain model Set
   * @return the destination Set
   */
  default Set<E> fromModel(Set<M> source) {
    return nullPassThroug(source, () -> source.stream().map(this::fromModel).collect(toSet()));
  }

  /**
   * To model stream.
   *
   * @param source the stream
   * @return the stream
   */
  default Stream<M> toModel(Stream<E> source) {
    return nullPassThroug(source, () -> source.map(this::toModel));
  }

  /**
   * From model stream.
   *
   * @param source the stream
   * @return the stream
   */
  default Stream<E> fromModel(Stream<M> source) {
    return nullPassThroug(source, () -> source.map(this::fromModel));
  }
}
