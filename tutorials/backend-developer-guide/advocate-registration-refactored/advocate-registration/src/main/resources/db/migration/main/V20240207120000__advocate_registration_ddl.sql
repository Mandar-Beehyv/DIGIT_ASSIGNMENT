
CREATE TABLE IF NOT EXISTS eg_organisation (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_by VARCHAR(64),
    last_modified_by VARCHAR(64),
    created_time BIGINT NOT NULL,
    last_modified_time BIGINT
);


CREATE TABLE IF NOT EXISTS eg_advocate_registration (
    id VARCHAR(255) PRIMARY KEY,
    tenant_id VARCHAR(128) NOT NULL CHECK (LENGTH(tenant_id) BETWEEN 2 AND 128),

    application_number VARCHAR(64) NOT NULL CHECK (LENGTH(application_number) BETWEEN 2 AND 64),
    bar_registration_number VARCHAR(64) NOT NULL UNIQUE CHECK (LENGTH(bar_registration_number) BETWEEN 2 AND 64),
    advocate_type VARCHAR(64) NOT NULL CHECK (LENGTH(advocate_type) BETWEEN 2 AND 64),

    organisation_id UUID,
    individual_id VARCHAR(64) NOT NULL,

    is_active BOOLEAN DEFAULT TRUE,

    created_by VARCHAR(64),
    last_modified_by VARCHAR(64),
    created_time BIGINT NOT NULL,
    last_modified_time BIGINT

);


