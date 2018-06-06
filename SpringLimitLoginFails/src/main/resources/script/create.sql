USE LimitLogin  
GO  

CREATE TABLE [dbo].[Permission](
	[perId] [bigint] PRIMARY KEY IDENTITY(1,1) NOT NULL,
	[perCode] [nvarchar](10) NOT NULL,
	[perName] [nvarchar](50) NOT NULL,
	[perDesc] [nvarchar](200) NULL,
	[createDate] [datetime] NOT NULL,
	[updateDate] [datetime] NULL
);

CREATE TABLE [dbo].[Role](
	[roleId] [int] PRIMARY KEY IDENTITY(1,1) NOT NULL,
	[roleName] [nvarchar](50) NOT NULL,
	[roleDesc] [nvarchar](200) NULL,
	[createDate] [datetime] NOT NULL,
	[updateDate] [datetime] NULL
);

CREATE TABLE [dbo].[Member](
	[username] [nvarchar](50) NOT NULL PRIMARY KEY,
	[password] [nvarchar](255) NOT NULL,
	[fkRoleId] [int] NULL,
	[enabled] [bit]  NOT NULL,
	[accountNonLocked] [bit] NOT NULL,
	[accountNonExpired] [bit] NOT NULL,
	[credentialsNonExpired] [bit] NOT NULL,
	[createDate] [datetime] NOT NULL,
	[updateDate] [datetime] NULL,
	CONSTRAINT fk_Member_Role FOREIGN KEY (fkRoleId)
    REFERENCES Role(roleId)
);

CREATE TABLE MemberAttempt (
  id [bigint] NOT NULL PRIMARY KEY IDENTITY(1,1),
  username [varchar](45) NOT NULL,
  attempts [int] NOT NULL,
  lastModified datetime NOT NULL
);

CREATE TABLE [dbo].[Role_Map_Permission](
	[id] [bigint]  NOT NULL PRIMARY KEY IDENTITY(1,1),
	[fkRoleId] [int] NULL,
	[fkPerId] [bigint] NULL,
	[createDate] [datetime] NOT NULL,
	CONSTRAINT FK_Role_Map_Permission_Role FOREIGN KEY (fkRoleId) REFERENCES Role(roleId),
	CONSTRAINT FK_Role_Map_Permission_Per FOREIGN KEY (fkPerId) REFERENCES Permission(perId)
);