package it.albertus.httpserver;

import java.util.logging.Level;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.TrustManagerFactory;

public abstract class DefaultHttpServerConfiguration implements IHttpServerConfiguration {

	public static final int DEFAULT_PORT = 8080;
	public static final boolean DEFAULT_ENABLED = true;
	public static final boolean DEFAULT_AUTHENTICATION = false;
	public static final String DEFAULT_PASSWORD_HASH_ALGORITHM = "SHA-256";
	public static final int DEFAULT_MAX_THREAD_COUNT = 15;
	public static final int DEFAULT_MIN_THREAD_COUNT = DEFAULT_MAX_THREAD_COUNT / 10;
	public static final long DEFAULT_THREAD_KEEP_ALIVE_TIME = 60L; // seconds
	public static final boolean DEFAULT_SSL_ENABLED = false;
	public static final String DEFAULT_SSL_KEYSTORE_TYPE = "JKS";
	public static final String DEFAULT_SSL_PROTOCOL = "TLS";
	public static final String DEFAULT_SSL_KMF_ALGORITHM = KeyManagerFactory.getDefaultAlgorithm();
	public static final String DEFAULT_SSL_TMF_ALGORITHM = TrustManagerFactory.getDefaultAlgorithm();
	public static final long DEFAULT_MAX_REQ_TIME = 60L; // seconds
	public static final long DEFAULT_MAX_RSP_TIME = 60L * 60 * 24; // seconds
	public static final Level DEFAULT_REQUEST_LOGGING_LEVEL = Level.INFO;
	public static final boolean DEFAULT_COMPRESSION_ENABLED = true;

	@Override
	public boolean isEnabled() {
		return DEFAULT_ENABLED;
	}

	@Override
	public boolean isAuthenticationRequired() {
		return DEFAULT_AUTHENTICATION;
	}

	@Override
	public String getPasswordHashAlgorithm() {
		return DEFAULT_PASSWORD_HASH_ALGORITHM;
	}

	@Override
	public int getPort() {
		return DEFAULT_PORT;
	}

	/**
	 * Returns the maximum time a request is allowed to take.
	 * 
	 * @return {@link #DEFAULT_MAX_REQ_TIME}.
	 */
	@Override
	public long getMaxReqTime() {
		return DEFAULT_MAX_REQ_TIME;
	}

	/**
	 * Returns the maximum time a response is allowed to take.
	 * 
	 * @return {@link #DEFAULT_MAX_RSP_TIME}.
	 */
	@Override
	public long getMaxRspTime() {
		return DEFAULT_MAX_RSP_TIME;
	}

	@Override
	public boolean isSslEnabled() {
		return DEFAULT_SSL_ENABLED;
	}

	@Override
	public String getKeyStoreType() {
		return DEFAULT_SSL_KEYSTORE_TYPE;
	}

	@Override
	public String getSslProtocol() {
		return DEFAULT_SSL_PROTOCOL;
	}

	@Override
	public String getKeyManagerFactoryAlgorithm() {
		return DEFAULT_SSL_KMF_ALGORITHM;
	}

	@Override
	public String getTrustManagerFactoryAlgorithm() {
		return DEFAULT_SSL_TMF_ALGORITHM;
	}

	/**
	 * Returns a copy of the SSLParameters indicating the default settings for
	 * the given SSL context.
	 *
	 * <p>
	 * The parameters will always have the ciphersuites and protocols arrays set
	 * to non-null values.
	 * 
	 * @param context the {@link javax.net.ssl.SSLContext SSLContext}.
	 * @return a copy of the SSLParameters object with the default settings
	 * @throws UnsupportedOperationException if the default SSL parameters could
	 *         not be obtained.
	 */
	@Override
	public SSLParameters getSslParameters(final SSLContext context) {
		return context.getDefaultSSLParameters();
	}

	/**
	 * Returns the maximum number of threads to allow in the pool.
	 * 
	 * @return {@link #DEFAULT_MAX_THREAD_COUNT}
	 */
	@Override
	public int getMaxThreadCount() {
		return DEFAULT_MAX_THREAD_COUNT;
	}

	/**
	 * Returns the number of threads to keep in the pool, even if they are idle.
	 * 
	 * @return {@link #getMaxThreadCount()} / 10.
	 */
	@Override
	public int getMinThreadCount() {
		return getMaxThreadCount() / 10;
	}

	@Override
	public long getThreadKeepAliveTime() {
		return DEFAULT_THREAD_KEEP_ALIVE_TIME;
	}

	@Override
	public String getRequestLoggingLevel() {
		return DEFAULT_REQUEST_LOGGING_LEVEL.getName();
	}

	@Override
	public boolean isCompressionEnabled() {
		return DEFAULT_COMPRESSION_ENABLED;
	}

	@Override
	public String getRealm() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public char[] getPassword() {
		return null;
	}

	@Override
	public char[] getStorePass() {
		return null;
	}

	@Override
	public String getKeyStoreFileName() {
		return null;
	}

	@Override
	public char[] getKeyPass() {
		return null;
	}

}
