create table bibboxdocker_DockerContainer (
	dockerContainerId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	startCommand TEXT null,
	toolName VARCHAR(75) null,
	instance VARCHAR(75) null,
	port VARCHAR(75) null,
	url VARCHAR(75) null,
	subdomain VARCHAR(75) null,
	ip VARCHAR(75) null,
	displayName VARCHAR(75) null,
	displayToolName VARCHAR(75) null,
	category VARCHAR(75) null,
	tool VARCHAR(75) null,
	description TEXT null,
	company VARCHAR(75) null,
	platform VARCHAR(75) null,
	license VARCHAR(75) null,
	toolDescription TEXT null,
	logourl VARCHAR(150) null
);