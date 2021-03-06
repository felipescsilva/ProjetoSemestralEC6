USE [master]
GO
/****** Object:  Database [CB20]    Script Date: 19/11/2020 18:01:05 ******/
CREATE DATABASE [CB20]
GO

USE [CB20]
GO
CREATE TABLE [dbo].[tblBanco](
	[idBanco] [int] IDENTITY(1,1) NOT NULL,
	[PatrimonioProprio] [money] NULL,
	[PatrimonioTerceiros] [money] NULL,
	[Faturamento] [money] NULL,
	[CustosFixos] [money] NULL,
	[CustosVariaveis] [money] NULL,
	[Impostos] [float] NULL,
	[LastUpdate] [datetime] NULL,
 CONSTRAINT [PK_tblBanco] PRIMARY KEY CLUSTERED 
(
	[idBanco] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblCambio]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCambio](
	[idCambio] [int] IDENTITY(1,1) NOT NULL,
	[NumConta] [nvarchar](20) NULL,
	[Valor] [money] NOT NULL,
	[Moeda] [nvarchar](100) NOT NULL,
	[Descricao] [nvarchar](200) NULL,
	[DataSolicitacao] [datetime] NULL,
	[DataValidade] [datetime] NULL,
 CONSTRAINT [PK_tblCambio] PRIMARY KEY CLUSTERED 
(
	[idCambio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblCartao]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCartao](
	[NumCartao] [nvarchar](50) NOT NULL,
	[NumConta] [nvarchar](20) NOT NULL,
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
/****** Object:  Table [dbo].[tblCliente]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCliente](
	[Nome] [nvarchar](100) NOT NULL,
	[CPF] [nvarchar](20) NOT NULL,
	[Telefone] [nvarchar](50) NULL,
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
/****** Object:  Table [dbo].[tblCompras]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCompras](
	[idCompras] [int] IDENTITY(1,1) NOT NULL,
	[NumCartao] [nvarchar](50) NOT NULL,
	[Descricao] [nvarchar](200) NULL,
	[Valor] [money] NOT NULL,
	[Data] [datetime] NULL,
 CONSTRAINT [PK_tblCompras] PRIMARY KEY CLUSTERED 
(
	[idCompras] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblConta]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblConta](
	[NumConta] [nvarchar](20) NOT NULL,
	[CPF] [nvarchar](20) NOT NULL,
	[Saldo] [money] NULL,
	[DataAbertura] [datetime] NULL,
	[SenhaConta] [nvarchar](100) NOT NULL,
	[SenhaApp] [nvarchar](100) NULL,
 CONSTRAINT [PK_tblConta] PRIMARY KEY CLUSTERED 
(
	[NumConta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblDepositos]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblDepositos](
	[idDepositos] [int] IDENTITY(1,1) NOT NULL,
	[CPF] [nvarchar](20) NOT NULL,
	[NumConta] [nvarchar](20) NOT NULL,
	[DataTransacao] [datetime] NOT NULL,
	[linhaDigitavel] [varchar](max) NULL,
	[Valor] [money] NOT NULL,
 CONSTRAINT [PK_tblDepositos] PRIMARY KEY CLUSTERED 
(
	[idDepositos] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblEmprestimos]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblEmprestimos](
	[idEmprestimo] [int] IDENTITY(1,1) NOT NULL,
	[CPF] [nvarchar](20) NOT NULL,
	[NumConta] [nvarchar](20) NOT NULL,
	[DataSolicitacao] [datetime] NULL,
	[TaxaJuros] [nvarchar](50) NULL,
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
/****** Object:  Table [dbo].[tblEndereco]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblEndereco](
	[idEndereco] [int] IDENTITY(1,1) NOT NULL,
	[CPF] [nvarchar](20) NOT NULL,
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
/****** Object:  Table [dbo].[tblExtrato]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblExtrato](
	[idExtrato] [int] IDENTITY(1,1) NOT NULL,
	[NumConta] [nvarchar](20) NULL,
	[Valor] [money] NULL,
	[DataTransacao] [datetime] NULL,
 CONSTRAINT [PK_tblExtrato] PRIMARY KEY CLUSTERED 
(
	[idExtrato] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblFatura]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblFatura](
	[idFatura] [int] IDENTITY(1,1) NOT NULL,
	[NumCartao] [nvarchar](50) NOT NULL,
	[DataVencimento] [datetime] NULL,
	[Valor] [money] NOT NULL,
	[Situacao] [nvarchar](100) NULL,
	[TipoFatura] [nvarchar](100) NULL,
	[TaxaJuros] [float] NULL,
 CONSTRAINT [PK_tblFatura] PRIMARY KEY CLUSTERED 
(
	[idFatura] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblFaturasEmprestimos]    Script Date: 19/11/2020 18:01:06 ******/
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
/****** Object:  Table [dbo].[tblPagamentos]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPagamentos](
	[idPagamento] [int] IDENTITY(1,1) NOT NULL,
	[CPF] [nvarchar](20) NOT NULL,
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
/****** Object:  Table [dbo].[tblTransferencia]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblTransferencia](
	[idTransferencia] [int] IDENTITY(1,1) NOT NULL,
	[CPF] [nvarchar](20) NOT NULL,
	[ContaOrigem] [nvarchar](50) NOT NULL,
	[ContaDestino] [nvarchar](50) NOT NULL,
	[Valor] [money] NOT NULL,
	[DataTransacao] [datetime] NOT NULL,
 CONSTRAINT [PK_tblTransferencia] PRIMARY KEY CLUSTERED 
(
	[idTransferencia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[tblCambio]  WITH CHECK ADD  CONSTRAINT [FK_tblCambio_tblConta] FOREIGN KEY([NumConta])
REFERENCES [dbo].[tblConta] ([NumConta])
GO
ALTER TABLE [dbo].[tblCambio] CHECK CONSTRAINT [FK_tblCambio_tblConta]
GO
ALTER TABLE [dbo].[tblCartao]  WITH CHECK ADD  CONSTRAINT [FK_tblCartao_tblConta] FOREIGN KEY([NumConta])
REFERENCES [dbo].[tblConta] ([NumConta])
GO
ALTER TABLE [dbo].[tblCartao] CHECK CONSTRAINT [FK_tblCartao_tblConta]
GO
ALTER TABLE [dbo].[tblCompras]  WITH CHECK ADD  CONSTRAINT [FK_tblCompras_tblCartao] FOREIGN KEY([NumCartao])
REFERENCES [dbo].[tblCartao] ([NumCartao])
GO
ALTER TABLE [dbo].[tblCompras] CHECK CONSTRAINT [FK_tblCompras_tblCartao]
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
ALTER TABLE [dbo].[tblExtrato]  WITH CHECK ADD  CONSTRAINT [FK_tblExtrato_tblConta] FOREIGN KEY([NumConta])
REFERENCES [dbo].[tblConta] ([NumConta])
GO
ALTER TABLE [dbo].[tblExtrato] CHECK CONSTRAINT [FK_tblExtrato_tblConta]
GO
ALTER TABLE [dbo].[tblFatura]  WITH CHECK ADD  CONSTRAINT [FK_tblFatura_tblCartao] FOREIGN KEY([NumCartao])
REFERENCES [dbo].[tblCartao] ([NumCartao])
GO
ALTER TABLE [dbo].[tblFatura] CHECK CONSTRAINT [FK_tblFatura_tblCartao]
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
/****** Object:  StoredProcedure [dbo].[sp_consulta]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_consulta](      
 @Tabela varchar(28),      
 @Campo varchar(28),        
 @Valor varchar(40)) as      
       
      
begin      
    DECLARE @sql VARCHAR(100) = 'SELECT * FROM ' + @Tabela + ' WHERE ' + @Campo + ' = ' + '''' +  @Valor + '''' 
	print(@sql)
 EXEC(@sql)   
end 

GO
/****** Object:  StoredProcedure [dbo].[sp_InsertBanco]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[sp_InsertBanco](  
   
 @PatrimonioProprio money,  
 @PatrimonioTerceiros money,  
 @Faturamento money,  
 @CustosFixos money,  
 @CustosVariaveis money,  
 @Impostos float) as    
   
  
begin  
 --desabilita contagem de registros  
 set nocount on  
 insert into tblBanco   
  values (@PatrimonioProprio, @PatrimonioTerceiros, @Faturamento, @CustosFixos, @CustosVariaveis, @Impostos, GETDATE())  
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end

GO
/****** Object:  StoredProcedure [dbo].[sp_InsertCambio]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_InsertCambio](      
       
 @conta nvarchar(28),
 @Valor money,
 @Moeda nvarchar(200),
 @desc nvarchar(200),
 @DataSolicitacao datetime,
 @DataValidade datetime) as      
       
      
begin      
 --desabilita contagem de registros      
 set nocount on      
 insert into tblCambio       
  values (rtrim(@conta), @Valor, upper(@Moeda), upper(@Desc), @DataSolicitacao, @DataValidade)      
 --verifica se ocorreu algum erro      
 if @@ERROR <> 0       
  return -1      
 else      
  return 0      
 --habilita contagem de registros      
 set nocount off      
      
end 

GO
/****** Object:  StoredProcedure [dbo].[sp_InsertCartao]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[sp_InsertCartao](    
     
 @NumCartao nvarchar(28),      
 @NumConta nvarchar(20),    
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
/****** Object:  StoredProcedure [dbo].[sp_insertCliente]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[sp_insertCliente](  
 @Name nvarchar(200),  
 @cpf nvarchar(28),  
 @telefone nvarchar(40),  
 @email nvarchar(200),  
 @dataNascimento datetime,  
 @formacao nvarchar(200),  
 @profissao nvarchar(100),  
 @renda nvarchar(200)) as   
  
begin  
 --desabilita contagem de registros  
 set nocount on  
 insert into tblCliente   
  values (upper(@Name), rtrim(@cpf), @telefone, rtrim(@email), @dataNascimento, @formacao, @profissao, @renda)  
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end  
  


GO
/****** Object:  StoredProcedure [dbo].[sp_InsertCompras]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_InsertCompras](      
       
 @NumCartao nvarchar(28),        
 @Desc nvarchar(200),
 @Valor money,
 @Data datetime) as      
       
      
begin      
 --desabilita contagem de registros      
 set nocount on      
 insert into tblCompras       
  values (@NumCartao, upper(@Desc), @Valor, @Data)      
 --verifica se ocorreu algum erro      
 if @@ERROR <> 0       
  return -1      
 else      
  return 0      
 --habilita contagem de registros      
 set nocount off      
      
end 

GO
/****** Object:  StoredProcedure [dbo].[sp_InsertConta]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 CREATE proc [dbo].[sp_InsertConta](  
   
 @NumConta nvarchar(20),  
 @cpf nvarchar(28),  
 @Saldo money,  
 @dataAbertura datetime,  
 @SenhaConta nvarchar(50),
 @SenhaApp nvarchar(50)) as  
   
  
begin  
 --desabilita contagem de registros  
 set nocount on  
 insert into tblConta   
  values (@NumConta, rtrim(@cpf), @Saldo, @dataAbertura, @SenhaConta, @SenhaApp)  
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end

GO
/****** Object:  StoredProcedure [dbo].[sp_InsertDepositos]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_InsertDepositos](  
  
 @cpf nvarchar(28),  
 @NumConta nvarchar(20),  
 @DataTransacao datetime,
 @linhaDigitavel varchar(max),
 @Valor money) as    
   
  
begin  
 --desabilita contagem de registros  
 set nocount on  
 insert into tblDepositos   
  values (rtrim(@cpf), @NumConta, @DataTransacao, @linhaDigitavel, @Valor)  
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end  

GO
/****** Object:  StoredProcedure [dbo].[sp_insertEmprestimos]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 CREATE proc [dbo].[sp_insertEmprestimos](  
   
 @cpf nvarchar(28),  
 @NumConta nvarchar(20),  
 @dataSolicitacao datetime,  
 @taxaJuros nvarchar(20),  
 @prazoPagamento datetime,  
 @valorTotal money,  
 @QuantParcelas int,  
 @valorParcelas money,  
 @Situacao nvarchar(200)) as  
   
  
begin  
 --desabilita contagem de registros  
 set nocount on  
 insert into tblEmprestimos   
  values (rtrim(@cpf), @NumConta, @dataSolicitacao, @taxaJuros, @prazoPagamento, @valorTotal, @QuantParcelas, @valorParcelas, upper(@Situacao))  
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end

GO
/****** Object:  StoredProcedure [dbo].[sp_insertEndereco]    Script Date: 19/11/2020 18:01:06 ******/
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
/****** Object:  StoredProcedure [dbo].[sp_InsertExtrato]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 CREATE proc [dbo].[sp_InsertExtrato](    
     
 @NumConta nvarchar(20),    
 @Valor money,    
 @dataTransacao datetime) as    
     
    
begin    
 --desabilita contagem de registros    
 set nocount on    
 insert into tblExtrato     
  values (@NumConta, @Valor, @dataTransacao)    
 --verifica se ocorreu algum erro    
 if @@ERROR <> 0     
  return -1    
 else    
  return 0    
 --habilita contagem de registros    
 set nocount off    
    
end

GO
/****** Object:  StoredProcedure [dbo].[sp_InsertFatura]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[sp_InsertFatura](  
   
 @NumCartao nvarchar(28),  
 @DataVencimento datetime,  
 @Valor money,  
 @Situacao nvarchar(200),  
 @TipoFatura nvarchar(200),  
 @TaxaJuros float) as    
   
  
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
/****** Object:  StoredProcedure [dbo].[sp_insertPagamentos]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 CREATE proc [dbo].[sp_insertPagamentos](  
   
 @cpf nvarchar(28),  
 @descricao nvarchar(400),  
 @codBarras nvarchar(400),  
 @valor money,  
 @dataTransacao datetime) as  
   
  
begin  
 --desabilita contagem de registros  
 set nocount on  
 insert into tblPagamentos   
  values (rtrim(@cpf), upper(@descricao), @codBarras, @valor, @dataTransacao)  
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end

GO
/****** Object:  StoredProcedure [dbo].[sp_insertTransferencia]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
  CREATE proc [dbo].[sp_insertTransferencia](  
   
 @cpf nvarchar(28),  
 @contaOrigem nvarchar(28),  
 @contaDestino nvarchar(28),  
 @valor money,  
 @dataTransacao datetime) as  
   
  
begin  
 --desabilita contagem de registros  
 set nocount on  
 insert into tblTransferencia   
  values (rtrim(@cpf), @contaOrigem, @contaDestino, @valor, @dataTransacao)  
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end

GO
/****** Object:  StoredProcedure [dbo].[sp_UpdateBanco]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[sp_UpdateBanco](  
  
 @idBanco int,
 @PatrimonioProprio money,  
 @PatrimonioTerceiros money,  
 @Faturamento money,  
 @CustosFixos money,  
 @CustosVariaveis money,  
 @Impostos float) as    
   
  
begin  
	--Verifica se registro existe na tabela conta  
	 if not exists (select * from tblBanco where idBanco = @idBanco)  
	 begin  
	  print 'Registro inexistente'  
	  return -1  
	 end  
 --desabilita contagem de registros  
 set nocount on  
 update tblBanco   
  set PatrimonioProprio = @PatrimonioProprio, PatrimonioTerceiros = @PatrimonioTerceiros, Faturamento=@Faturamento, 
  CustosFixos=@CustosFixos, CustosVariaveis=@CustosVariaveis, Impostos=@Impostos, LastUpdate=GETDATE() 
  where idBanco = @idBanco
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end

GO
/****** Object:  StoredProcedure [dbo].[sp_updateCambio]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_updateCambio](      
       
 @id int,
 @Valor money,
 @Moeda nvarchar(200),
 @desc nvarchar(200),
 @DataSolicitacao datetime,
 @DataValidade datetime) as      
       
      
begin    
--Verifica se registro existe na tabela cambio    
 if not exists (select * from tblCambio where idCambio = @id)    
 begin    
  print 'Registro inexistente'    
  return -1    
 end   
 --desabilita contagem de registros      
 set nocount on      
 update tblCambio       
  set Valor=@Valor, Moeda=UPPER(@Moeda), Descricao=UPPER(@desc), DataSolicitacao=@DataSolicitacao, @DataValidade=@DataValidade
  where idCambio = @id
 --verifica se ocorreu algum erro      
 if @@ERROR <> 0       
  return -1      
 else      
  return 0      
 --habilita contagem de registros      
 set nocount off      
      
end 

GO
/****** Object:  StoredProcedure [dbo].[sp_updateCartao]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_updateCartao](      
       
 @NumCartao nvarchar(28),            
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
/****** Object:  StoredProcedure [dbo].[sp_updateCliente]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_updateCliente](      
       
  @Name nvarchar(200),    
  @cpf nvarchar(28),    
  @telefone nvarchar(40),    
  @email nvarchar(200),       
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
/****** Object:  StoredProcedure [dbo].[sp_updateConta]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_updateConta](    
     
 @NumConta nvarchar(20),     
 @Saldo money,      
 @SenhaConta nvarchar(50),
 @SenhaApp nvarchar(50)) as    
     
    
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
  set Saldo=@Saldo, SenhaConta=@SenhaConta, SenhaApp=@SenhaApp   
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
/****** Object:  StoredProcedure [dbo].[sp_updateEmprestimos]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_updateEmprestimos](    
    
 @id int,   
 @dataSolicitacao datetime,    
 @taxaJuros nvarchar(20),    
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
/****** Object:  StoredProcedure [dbo].[sp_updateEndereco]    Script Date: 19/11/2020 18:01:06 ******/
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
/****** Object:  StoredProcedure [dbo].[sp_updateFatura]    Script Date: 19/11/2020 18:01:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[sp_updateFatura](    
     
 @id int,  
 @DataVencimento datetime,    
 @Valor money,    
 @Situacao nvarchar(200),    
 @TipoFatura nvarchar(200),    
 @TaxaJuros float) as      
     
    
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
