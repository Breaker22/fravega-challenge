package ar.com.fravega.fravegaChallenge.interfaces;

import ar.com.fravega.fravegaChallenge.exception.NodeNotFoudException;
import ar.com.fravega.fravegaChallenge.response.NodeResponse;

public interface NodeInterface {

	NodeResponse findNode(Long id) throws NodeNotFoudException;
}
