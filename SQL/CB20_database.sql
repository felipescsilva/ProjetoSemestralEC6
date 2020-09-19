USE [master]
GO
/****** Object:  Database [CB20]    Script Date: 19/09/2020 19:45:26 ******/
CREATE DATABASE [CB20]
 
USE [CB20]
GO
/****** Object:  Table [dbo].[tblCartao]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCartao](
	[NumCartao] [nchar](30) NOT NULL,
	[NumConta] [nchar](10) NOT NULL,
	[Tipo] [nvarchar](100) NOT NULL,
	[Moeda] [nvarchar](100) NULL,
	[Saldo] [money] NULL,
	[flagBloqueado] [nvarchar](100) NULL,
	[LimiteTotal] [float] NULL,
	[LimiteUsado] [float] NULL,
	[MotivoBloqueio] [nvarchar](100) NULL,
	[CVV] [nvarchar](30) NULL,
	[DataValidade] [datetime] NULL,
 CONSTRAINT [PK_tblCartao] PRIMARY KEY CLUSTERED 
(
	[NumCartao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblCliente]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCliente](
	[Nome] [nvarchar](100) NOT NULL,
	[CPF] [nvarchar](14) NOT NULL,
	[Telefone] [nchar](20) NULL,
	[Email] [nvarchar](100) NULL,
	[DataNascimento] [datetime] NOT NULL,
	[Formacao] [nvarchar](100) NULL,
	[Profissao] [nvarchar](50) NULL,
	[Renda] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_tblCliente] PRIMARY KEY CLUSTERED 
(
	[CPF] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblConta]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblConta](
	[NumConta] [nchar](10) NOT NULL,
	[CPF] [nvarchar](14) NOT NULL,
	[Saldo] [money] NULL,
	[DataAbertura] [datetime] NULL,
	[Senha] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_tblConta] PRIMARY KEY CLUSTERED 
(
	[NumConta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblDepositos]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblDepositos](
	[idDepositos] [int] IDENTITY(1,1) NOT NULL,
	[CPF] [nvarchar](14) NOT NULL,
	[NumConta] [nchar](10) NOT NULL,
	[DataTransacao] [datetime] NOT NULL,
	[Valor] [money] NOT NULL,
 CONSTRAINT [PK_tblDepositos] PRIMARY KEY CLUSTERED 
(
	[idDepositos] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblEmprestimos]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblEmprestimos](
	[idEmprestimo] [int] IDENTITY(1,1) NOT NULL,
	[CPF] [nvarchar](14) NOT NULL,
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
/****** Object:  Table [dbo].[tblEndereco]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblEndereco](
	[idEndereco] [int] IDENTITY(1,1) NOT NULL,
	[CPF] [nvarchar](14) NOT NULL,
	[Endereco] [nvarchar](200) NULL,
	[Numero] [int] NULL,
	[CEP] [nvarchar](50) NULL,
	[Cidade] [nvarchar](200) NULL,
	[Estado] [nvarchar](200) NULL,
	[Pais] [nvarchar](200) NULL,
 CONSTRAINT [PK_tblEndereco] PRIMARY KEY CLUSTERED 
(
	[idEndereco] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblFatura]    Script Date: 19/09/2020 19:45:26 ******/
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
/****** Object:  Table [dbo].[tblFaturasEmprestimos]    Script Date: 19/09/2020 19:45:26 ******/
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
/****** Object:  Table [dbo].[tblPagamentos]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPagamentos](
	[idPagamento] [int] IDENTITY(1,1) NOT NULL,
	[CPF] [nvarchar](14) NOT NULL,
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
/****** Object:  Table [dbo].[tblTransferencia]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblTransferencia](
	[idTransferencia] [int] IDENTITY(1,1) NOT NULL,
	[CPF] [nvarchar](14) NOT NULL,
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
ALTER TABLE [dbo].[tblEndereco]  WITH CHECK ADD  CONSTRAINT [FK_tblEndereco_tblCliente] FOREIGN KEY([CPF])
REFERENCES [dbo].[tblCliente] ([CPF])
GO
ALTER TABLE [dbo].[tblEndereco] CHECK CONSTRAINT [FK_tblEndereco_tblCliente]
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
/****** Object:  StoredProcedure [dbo].[sp_InsertCartao]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_InsertCartao](  
   
 @NumCartao nchar(28),    
 @NumConta nchar(20),  
 @tipo nvarchar(40),  
 @Moeda nvarchar(40),  
 @Saldo money,  
 @flag nvarchar(100), -- Bloqueado: 0 / Desbloqueado: 1  / Bloqueio Definitivo: 2
 @limTotal float,
 @limUsado float,
 @MotBloqueio nvarchar(160),
 @cvv nvarchar(40),
 @dataValidade datetime) as  
   
  
begin  
 --desabilita contagem de registros  
 set nocount on  
 insert into tblCartao   
  values (@NumCartao, @NumConta, upper(@tipo), upper(@Moeda), @Saldo, upper(@flag), @limTotal, @limUsado, upper(@MotBloqueio), @cvv, @dataValidade)  
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end
GO
/****** Object:  StoredProcedure [dbo].[sp_insertCliente]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[sp_insertCliente](
	@Name nvarchar(200),
	@cpf nchar(28),
	@telefone nchar(40),
	@email nvarchar(200),
	@dataNascimento datetime,
	@formacao nvarchar(200),
	@profissao nvarchar(100),
	@renda nvarchar(200)) as 

begin
	--desabilita contagem de registros
	set nocount on
	insert into tblCliente 
		values (upper(@Name), rtrim(@cpf), @telefone, rtrim(@email), @dataNascimento, upper(@formacao), upper(@profissao), @renda)
	--verifica se ocorreu algum erro
	if @@ERROR <> 0 
		return -1
	else
		return 0
	--habilita contagem de registros
	set nocount off

end

GO
/****** Object:  StoredProcedure [dbo].[sp_InsertConta]    Script Date: 19/09/2020 19:45:26 ******/
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
/****** Object:  StoredProcedure [dbo].[sp_InsertDepositos]    Script Date: 19/09/2020 19:45:26 ******/
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
/****** Object:  StoredProcedure [dbo].[sp_insertEmprestimos]    Script Date: 19/09/2020 19:45:26 ******/
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
/****** Object:  StoredProcedure [dbo].[sp_insertEndereco]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_insertEndereco](  
 @cpf nvarchar(20),
 @endereco nvarchar(200),
 @numero int,
 @cep nvarchar(200),
 @cidade nvarchar(200),
 @estado nvarchar(200),
 @pais nvarchar(200)) as   
  
begin  
 --desabilita contagem de registros  
 set nocount on  
 insert into tblEndereco   
  values (rtrim(@cpf), upper(@endereco), @numero, rtrim(@cep), upper(@cidade), upper(@estado), upper(@pais))  
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end
GO
/****** Object:  StoredProcedure [dbo].[sp_InsertFatura]    Script Date: 19/09/2020 19:45:26 ******/
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
/****** Object:  StoredProcedure [dbo].[sp_insertPagamentos]    Script Date: 19/09/2020 19:45:26 ******/
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
/****** Object:  StoredProcedure [dbo].[sp_insertTransferencia]    Script Date: 19/09/2020 19:45:26 ******/
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
/****** Object:  StoredProcedure [dbo].[sp_updateCartao]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_updateCartao](    
     
 @NumCartao nchar(28),          
 @tipo nvarchar(40),    
 @Moeda nvarchar(40),    
 @Saldo money,    
 @flag nvarchar(100), -- Bloqueado: 0 / Desbloqueado: 1  / Bloqueio Definitivo: 2  
 @limTotal float,  
 @limUsado float,  
 @MotBloqueio nvarchar(160),  
 @cvv nvarchar(40),  
 @dataValidade datetime) as    
     
    
begin    
	--Verifica se registro existe na tabela cartao
	if not exists (select * from tblCartao where NumCartao = @NumCartao)
	begin
		print 'Registro inexistente'
		return -1
	end
 --desabilita contagem de registros    
 set nocount on    
 update tblCartao     
  set Tipo=upper(@tipo), Moeda=upper(@Moeda), Saldo=@Saldo, flagBloqueado=upper(@flag), LimiteTotal=@limTotal, LimiteUsado=@limUsado, MotivoBloqueio=upper(@MotBloqueio), 
  CVV=rtrim(@cvv), DataValidade=@dataValidade  
  where NumCartao = @NumCartao
 --verifica se ocorreu algum erro    
 if @@ERROR <> 0     
  return -1    
 else    
  return 0    
 --habilita contagem de registros    
 set nocount off    
    
end  
GO
/****** Object:  StoredProcedure [dbo].[sp_updateCliente]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_updateCliente](    
     
	 @Name nvarchar(200),  
	 @cpf nchar(28),  
	 @telefone nchar(40),  
	 @email nvarchar(200),    
	 @address nvarchar(400),  
	 @formacao nvarchar(200),  
	 @profissao nvarchar(100),  
	 @renda nvarchar(200)) as     
     
    
begin  

 --Verifica se registro existe na tabela cliente
	if not exists (select * from tblCliente where CPF = @cpf)
	begin
		print 'Registro inexistente'
		return -1
	end
 --desabilita contagem de registros    
 set nocount on    
 update tblCliente set Nome = upper(@Name), Telefone = rtrim(@telefone), Email = upper(@email),
 Formacao = upper(@formacao), Profissao = upper(@profissao), Renda = rtrim(@renda)
 where CPF = @cpf
 --verifica se ocorreu algum erro    
 if @@ERROR <> 0     
  return -1    
 else    
  return 0    
 --habilita contagem de registros    
 set nocount off    
    
end  
GO
/****** Object:  StoredProcedure [dbo].[sp_updateConta]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_updateConta](  
   
 @NumConta nchar(20),   
 @Saldo money,    
 @Senha nvarchar(20)) as  
   
  
begin  
	--Verifica se registro existe na tabela conta
	if not exists (select * from tblConta where NumConta = @NumConta)
	begin
		print 'Registro inexistente'
		return -1
	end
 --desabilita contagem de registros  
 set nocount on  
 update tblConta   
  set Saldo=@Saldo, Senha=@Senha 
  where NumConta = @NumConta
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end
GO
/****** Object:  StoredProcedure [dbo].[sp_updateEmprestimos]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_updateEmprestimos](  
  
 @id int, 
 @dataSolicitacao datetime,  
 @taxaJuros nchar(20),  
 @prazoPagamento datetime,  
 @valorTotal money,  
 @QuantParcelas int,  
 @valorParcelas money,  
 @Situacao nvarchar(200)) as  
   
  
begin  

--Verifica se registro existe na tabela emprestimos
	if not exists (select * from tblEmprestimos where idEmprestimo = @id)
	begin
		print 'Registro inexistente'
		return -1
	end
 --desabilita contagem de registros  
 set nocount on  
 update tblEmprestimos   
  set DataSolicitacao = @dataSolicitacao, TaxaJuros = @taxaJuros, PrazoPagamento = @prazoPagamento, ValorTotal = @valorTotal, QuantParcelas = @QuantParcelas, 
  ValorParcelas = @valorParcelas, Situacao = upper(@Situacao)
  where idEmprestimo = @id
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end
GO
/****** Object:  StoredProcedure [dbo].[sp_updateEndereco]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_updateEndereco](  
 @id int,
 @endereco nvarchar(200),
 @numero int,
 @cep nvarchar(200),
 @cidade nvarchar(200),
 @estado nvarchar(200),
 @pais nvarchar(200)) as   
  
begin  
  --Verifica se registro existe na tabela cartao
	if not exists (select * from tblEndereco where idEndereco = @id)
	begin
		print 'Registro inexistente'
		return -1
	end
 --desabilita contagem de registros  
 set nocount on  
 update tblEndereco set Endereco=upper(@endereco), Numero=@numero, CEP=rtrim(@cep), Cidade=upper(@cidade), Estado=upper(@estado), Pais=upper(@pais)  
  where idEndereco = @id
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end
GO
/****** Object:  StoredProcedure [dbo].[sp_updateFatura]    Script Date: 19/09/2020 19:45:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_updateFatura](  
   
 @id int,
 @DataVencimento datetime,  
 @Valor money,  
 @Situacao nvarchar(200),  
 @TipoFatura nvarchar(200),  
 @TaxaJuros nchar(20)) as    
   
  
begin  
	--Verifica se registro existe na tabela conta
	if not exists (select * from tblFatura where idFatura = @id)
	begin
		print 'Registro inexistente'
		return -1
	end
 --desabilita contagem de registros  
 set nocount on  
 update tblFatura   
  set DataVencimento=@DataVencimento, Valor=@Valor, Situacao=UPPER(@Situacao), TipoFatura=UPPER(@TipoFatura), TaxaJuros=rtrim(@TaxaJuros)
  where idFatura = @id
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
