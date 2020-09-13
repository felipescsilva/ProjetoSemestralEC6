USE [master]
GO
/****** Object:  Database [CB20]    Script Date: 13/09/2020 16:47:02 ******/
CREATE DATABASE [CB20]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'CB20', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\CB20.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'CB20_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\CB20_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [CB20] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [CB20].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [CB20] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [CB20] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [CB20] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [CB20] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [CB20] SET ARITHABORT OFF 
GO
ALTER DATABASE [CB20] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [CB20] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [CB20] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [CB20] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [CB20] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [CB20] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [CB20] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [CB20] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [CB20] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [CB20] SET  ENABLE_BROKER 
GO
ALTER DATABASE [CB20] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [CB20] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [CB20] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [CB20] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [CB20] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [CB20] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [CB20] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [CB20] SET RECOVERY FULL 
GO
ALTER DATABASE [CB20] SET  MULTI_USER 
GO
ALTER DATABASE [CB20] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [CB20] SET DB_CHAINING OFF 
GO
ALTER DATABASE [CB20] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [CB20] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [CB20] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'CB20', N'ON'
GO
ALTER DATABASE [CB20] SET QUERY_STORE = OFF
GO
USE [CB20]
GO
/****** Object:  Table [dbo].[tblCartao]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCartao](
	[NumCartao] [nchar](30) NOT NULL,
	[CPF] [nchar](14) NOT NULL,
	[NumConta] [nchar](10) NOT NULL,
	[Tipo] [nchar](20) NOT NULL,
	[Moeda] [nchar](20) NOT NULL,
	[Saldo] [money] NOT NULL,
	[flagBloqueado] [int] NULL,
 CONSTRAINT [PK_tblCartao] PRIMARY KEY CLUSTERED 
(
	[NumCartao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblCliente]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCliente](
	[Nome] [nvarchar](100) NOT NULL,
	[CPF] [nchar](14) NOT NULL,
	[Telefone] [nchar](20) NULL,
	[Email] [nvarchar](100) NULL,
	[DataNascimento] [datetime] NOT NULL,
	[Endereco] [nvarchar](200) NULL,
	[Formacao] [nvarchar](100) NULL,
	[Profissao] [nvarchar](50) NULL,
	[Renda] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_tblCliente] PRIMARY KEY CLUSTERED 
(
	[CPF] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblConta]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblConta](
	[NumConta] [nchar](10) NOT NULL,
	[CPF] [nchar](14) NOT NULL,
	[Saldo] [money] NULL,
	[DataAbertura] [datetime] NULL,
	[Senha] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_tblConta] PRIMARY KEY CLUSTERED 
(
	[NumConta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblDepositos]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblDepositos](
	[idDepositos] [int] IDENTITY(1,1) NOT NULL,
	[CPF] [nchar](14) NOT NULL,
	[NumConta] [nchar](10) NOT NULL,
	[DataTransacao] [datetime] NOT NULL,
	[Valor] [money] NOT NULL,
 CONSTRAINT [PK_tblDepositos] PRIMARY KEY CLUSTERED 
(
	[idDepositos] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblEmprestimos]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblEmprestimos](
	[idEmprestimo] [int] IDENTITY(1,1) NOT NULL,
	[CPF] [nchar](14) NOT NULL,
	[NumConta] [nchar](10) NOT NULL,
	[DataSolicitacao] [datetime] NULL,
	[TaxaJuros] [nchar](10) NULL,
	[PrazoPagamento] [datetime] NULL,
	[ValorTotal] [money] NULL,
	[QuantParcelas] [int] NULL,
	[ValorParcelas] [money] NULL,
	[Situacao] [nvarchar](100) NULL,
 CONSTRAINT [PK_tblEmprestimos] PRIMARY KEY CLUSTERED 
(
	[idEmprestimo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblFatura]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblFatura](
	[idFatura] [int] IDENTITY(1,1) NOT NULL,
	[NumCartao] [nchar](30) NOT NULL,
	[DataVencimento] [datetime] NULL,
	[Valor] [money] NOT NULL,
	[Situacao] [nvarchar](100) NULL,
	[TipoFatura] [nvarchar](100) NULL,
	[TaxaJuros] [nchar](10) NULL,
 CONSTRAINT [PK_tblFatura] PRIMARY KEY CLUSTERED 
(
	[idFatura] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblFaturasEmprestimos]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblFaturasEmprestimos](
	[idFatEmp] [int] IDENTITY(1,1) NOT NULL,
	[idFaturas] [int] NOT NULL,
	[idEmprestimos] [int] NOT NULL,
 CONSTRAINT [PK_tblFaturasEmprestimos] PRIMARY KEY CLUSTERED 
(
	[idFatEmp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblPagamentos]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPagamentos](
	[idPagamento] [int] IDENTITY(1,1) NOT NULL,
	[CPF] [nchar](14) NOT NULL,
	[Descricao] [nvarchar](400) NULL,
	[codBarras] [nvarchar](400) NULL,
	[Valor] [money] NOT NULL,
	[DataTransacao] [datetime] NOT NULL,
 CONSTRAINT [PK_tblPagamentos] PRIMARY KEY CLUSTERED 
(
	[idPagamento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblTransferencia]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblTransferencia](
	[idTransferencia] [int] IDENTITY(1,1) NOT NULL,
	[CPF] [nchar](14) NOT NULL,
	[ContaOrigem] [nchar](10) NOT NULL,
	[ContaDestino] [nchar](10) NOT NULL,
	[Valor] [money] NOT NULL,
	[DataTransacao] [datetime] NOT NULL,
 CONSTRAINT [PK_tblTransferencia] PRIMARY KEY CLUSTERED 
(
	[idTransferencia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tblCartao]  WITH CHECK ADD  CONSTRAINT [FK_tblCartao_tblCliente] FOREIGN KEY([CPF])
REFERENCES [dbo].[tblCliente] ([CPF])
GO
ALTER TABLE [dbo].[tblCartao] CHECK CONSTRAINT [FK_tblCartao_tblCliente]
GO
ALTER TABLE [dbo].[tblCartao]  WITH CHECK ADD  CONSTRAINT [FK_tblCartao_tblConta] FOREIGN KEY([NumConta])
REFERENCES [dbo].[tblConta] ([NumConta])
GO
ALTER TABLE [dbo].[tblCartao] CHECK CONSTRAINT [FK_tblCartao_tblConta]
GO
ALTER TABLE [dbo].[tblConta]  WITH CHECK ADD  CONSTRAINT [FK_tblConta_tblCliente] FOREIGN KEY([CPF])
REFERENCES [dbo].[tblCliente] ([CPF])
GO
ALTER TABLE [dbo].[tblConta] CHECK CONSTRAINT [FK_tblConta_tblCliente]
GO
ALTER TABLE [dbo].[tblDepositos]  WITH CHECK ADD  CONSTRAINT [FK_tblDepositos_tblCliente] FOREIGN KEY([CPF])
REFERENCES [dbo].[tblCliente] ([CPF])
GO
ALTER TABLE [dbo].[tblDepositos] CHECK CONSTRAINT [FK_tblDepositos_tblCliente]
GO
ALTER TABLE [dbo].[tblDepositos]  WITH CHECK ADD  CONSTRAINT [FK_tblDepositos_tblConta] FOREIGN KEY([NumConta])
REFERENCES [dbo].[tblConta] ([NumConta])
GO
ALTER TABLE [dbo].[tblDepositos] CHECK CONSTRAINT [FK_tblDepositos_tblConta]
GO
ALTER TABLE [dbo].[tblEmprestimos]  WITH CHECK ADD  CONSTRAINT [FK_tblEmprestimos_tblCliente] FOREIGN KEY([CPF])
REFERENCES [dbo].[tblCliente] ([CPF])
GO
ALTER TABLE [dbo].[tblEmprestimos] CHECK CONSTRAINT [FK_tblEmprestimos_tblCliente]
GO
ALTER TABLE [dbo].[tblEmprestimos]  WITH CHECK ADD  CONSTRAINT [FK_tblEmprestimos_tblConta] FOREIGN KEY([NumConta])
REFERENCES [dbo].[tblConta] ([NumConta])
GO
ALTER TABLE [dbo].[tblEmprestimos] CHECK CONSTRAINT [FK_tblEmprestimos_tblConta]
GO
ALTER TABLE [dbo].[tblFatura]  WITH CHECK ADD  CONSTRAINT [FK_tblFatura_tblCartao] FOREIGN KEY([NumCartao])
REFERENCES [dbo].[tblCartao] ([NumCartao])
GO
ALTER TABLE [dbo].[tblFatura] CHECK CONSTRAINT [FK_tblFatura_tblCartao]
GO
ALTER TABLE [dbo].[tblFaturasEmprestimos]  WITH CHECK ADD  CONSTRAINT [FK_tblFaturasEmprestimos_tblEmprestimos] FOREIGN KEY([idEmprestimos])
REFERENCES [dbo].[tblEmprestimos] ([idEmprestimo])
GO
ALTER TABLE [dbo].[tblFaturasEmprestimos] CHECK CONSTRAINT [FK_tblFaturasEmprestimos_tblEmprestimos]
GO
ALTER TABLE [dbo].[tblFaturasEmprestimos]  WITH CHECK ADD  CONSTRAINT [FK_tblFaturasEmprestimos_tblFatura] FOREIGN KEY([idFaturas])
REFERENCES [dbo].[tblFatura] ([idFatura])
GO
ALTER TABLE [dbo].[tblFaturasEmprestimos] CHECK CONSTRAINT [FK_tblFaturasEmprestimos_tblFatura]
GO
ALTER TABLE [dbo].[tblPagamentos]  WITH CHECK ADD  CONSTRAINT [FK_tblPagamentos_tblCliente] FOREIGN KEY([CPF])
REFERENCES [dbo].[tblCliente] ([CPF])
GO
ALTER TABLE [dbo].[tblPagamentos] CHECK CONSTRAINT [FK_tblPagamentos_tblCliente]
GO
ALTER TABLE [dbo].[tblTransferencia]  WITH CHECK ADD  CONSTRAINT [FK_tblTransferencia_tblCliente] FOREIGN KEY([CPF])
REFERENCES [dbo].[tblCliente] ([CPF])
GO
ALTER TABLE [dbo].[tblTransferencia] CHECK CONSTRAINT [FK_tblTransferencia_tblCliente]
GO
/****** Object:  StoredProcedure [dbo].[sp_InsertCartao]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_InsertCartao](
	
	@NumCartao nchar(28),
	@cpf nchar(28),
	@NumConta nchar(20),
	@tipo nchar(40),
	@Moeda nchar(40),
	@Saldo money,
	@flag int) as  -- Bloqueado: 0 / Desbloqueado: 1
	

begin
	--desabilita contagem de registros
	set nocount on
	insert into tblCartao 
		values (@NumCartao, trim(@cpf), @NumConta, upper(@tipo), upper(@Moeda), @Saldo, @flag)
	--verifica se ocorreu algum erro
	if @@ERROR <> 0 
		return -1
	else
		return 0
	--habilita contagem de registros
	set nocount off

end
GO
/****** Object:  StoredProcedure [dbo].[sp_insertCliente]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_insertCliente](
	@Name nvarchar(200),
	@cpf nchar(28),
	@telefone nchar(40),
	@email nvarchar(200),
	@dataNascimento datetime,
	@address nvarchar(400),
	@formacao nvarchar(200),
	@profissao nvarchar(100),
	@renda nvarchar(200)) as 

begin
	--desabilita contagem de registros
	set nocount on
	insert into tblCliente 
		values (upper(@Name), trim(@cpf), @telefone, trim(@email), @dataNascimento, @address, @formacao, upper(@profissao), @renda)
	--verifica se ocorreu algum erro
	if @@ERROR <> 0 
		return -1
	else
		return 0
	--habilita contagem de registros
	set nocount off

end
GO
/****** Object:  StoredProcedure [dbo].[sp_InsertConta]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_InsertConta](
	
	@NumConta nchar(20),
	@cpf nchar(28),
	@Saldo money,
	@dataAbertura datetime,
	@Senha nvarchar(20)) as
	

begin
	--desabilita contagem de registros
	set nocount on
	insert into tblConta 
		values (@NumConta, trim(@cpf), @Saldo, @dataAbertura, @Senha)
	--verifica se ocorreu algum erro
	if @@ERROR <> 0 
		return -1
	else
		return 0
	--habilita contagem de registros
	set nocount off

end
GO
/****** Object:  StoredProcedure [dbo].[sp_InsertDepositos]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_InsertDepositos](

	@cpf nchar(28),
	@NumConta nchar(20),
	@DataTransacao datetime,
	@Valor money) as  
	

begin
	--desabilita contagem de registros
	set nocount on
	insert into tblDepositos 
		values (trim(@cpf), @NumConta, @DataTransacao, @Valor)
	--verifica se ocorreu algum erro
	if @@ERROR <> 0 
		return -1
	else
		return 0
	--habilita contagem de registros
	set nocount off

end
GO
/****** Object:  StoredProcedure [dbo].[sp_insertEmprestimos]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_insertEmprestimos](
	
	@cpf nchar(28),
	@NumConta nchar(20),
	@dataSolicitacao datetime,
	@taxaJuros nchar(20),
	@prazoPagamento datetime,
	@valorTotal money,
	@QuantParcelas int,
	@valorParcelas money,
	@Situacao nvarchar(200)) as
	

begin
	--desabilita contagem de registros
	set nocount on
	insert into tblEmprestimos 
		values (trim(@cpf), @NumConta, @dataSolicitacao, @taxaJuros, @prazoPagamento, @valorTotal, @QuantParcelas, @valorParcelas, upper(@Situacao))
	--verifica se ocorreu algum erro
	if @@ERROR <> 0 
		return -1
	else
		return 0
	--habilita contagem de registros
	set nocount off

end
GO
/****** Object:  StoredProcedure [dbo].[sp_InsertFatura]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_InsertFatura](
	
	@NumCartao nchar(28),
	@DataVencimento datetime,
	@Valor money,
	@Situacao nvarchar(200),
	@TipoFatura nvarchar(200),
	@TaxaJuros nchar(20)) as  
	

begin
	--desabilita contagem de registros
	set nocount on
	insert into tblFatura 
		values (@NumCartao, @DataVencimento, @Valor, upper(@Situacao), upper(@TipoFatura), @TaxaJuros)
	--verifica se ocorreu algum erro
	if @@ERROR <> 0 
		return -1
	else
		return 0
	--habilita contagem de registros
	set nocount off

end
GO
/****** Object:  StoredProcedure [dbo].[sp_insertPagamentos]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_insertPagamentos](
	
	@cpf nchar(28),
	@descricao nvarchar(400),
	@codBarras nvarchar(400),
	@valor money,
	@dataTransacao datetime) as
	

begin
	--desabilita contagem de registros
	set nocount on
	insert into tblPagamentos 
		values (trim(@cpf), upper(@descricao), @codBarras, @valor, @dataTransacao)
	--verifica se ocorreu algum erro
	if @@ERROR <> 0 
		return -1
	else
		return 0
	--habilita contagem de registros
	set nocount off

end
GO
/****** Object:  StoredProcedure [dbo].[sp_insertTransferencia]    Script Date: 13/09/2020 16:47:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_insertTransferencia](
	
	@cpf nchar(28),
	@contaOrigem nvarchar(28),
	@contaDestino nvarchar(28),
	@valor money,
	@dataTransacao datetime) as
	

begin
	--desabilita contagem de registros
	set nocount on
	insert into tblTransferencia 
		values (trim(@cpf), @contaOrigem, @contaDestino, @valor, @dataTransacao)
	--verifica se ocorreu algum erro
	if @@ERROR <> 0 
		return -1
	else
		return 0
	--habilita contagem de registros
	set nocount off

end
GO
USE [master]
GO
ALTER DATABASE [CB20] SET  READ_WRITE 
GO
