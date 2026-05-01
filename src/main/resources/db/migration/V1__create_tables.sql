CREATE TABLE users(
                      id BIGSERIAL PRIMARY KEY,
                      nome VARCHAR(150) NOT NULL,
                      email VARCHAR(254) NOT NULL UNIQUE,
                      senha VARCHAR(255) NOT NULL,
                      created_at TIMESTAMP NOT NULL,
                      updated_at TIMESTAMP
);

CREATE TABLE transacoes(
                           id BIGSERIAL PRIMARY KEY,
                           descricao VARCHAR(300) NOT NULL,
                           valor NUMERIC(19, 2) NOT NULL,
                           tipo VARCHAR(20) NOT NULL,
                           categoria VARCHAR(50) NOT NULL,
                           usuario_id BIGINT NOT NULL,
                           created_at TIMESTAMP NOT NULL,
                           updated_at TIMESTAMP,
                           CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES users(id)
);