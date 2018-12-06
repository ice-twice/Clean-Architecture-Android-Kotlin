package com.architecture.clean.domain.interactor.abstractinteractor.adapter.observer

/**
 * Holder for different observers from the reactive library.
 * This class is used to create the base class for different observers.
 */
class ObserverAdapter<Observer>(val observer: Observer)